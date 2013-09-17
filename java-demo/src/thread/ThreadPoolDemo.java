package thread;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolDemo {
	public static void main(String[] args) throws Exception {
		ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

		threadPoolDemo.testFun();

		threadPoolDemo.testSeachKeyword();
	}

	/**
	 * A thread pool manages the pool of worker threads, it contains a queue
	 * that keeps tasks waiting to get executed.
	 * 
	 * A thread pool manages the collection of Runnable threads and worker
	 * threads execute Runnable from the queue.
	 * 
	 * pool-1-thread-1 Start. Command = 0 pool-1-thread-2 Start. Command = 1
	 * pool-1-thread-5 Start. Command = 4 pool-1-thread-3 Start. Command = 2
	 * pool-1-thread-4 Start. Command = 3 pool-1-thread-2 End. pool-1-thread-2
	 * Start. Command = 5 pool-1-thread-1 End. pool-1-thread-1 Start. Command =
	 * 6 pool-1-thread-5 End. pool-1-thread-5 Start. Command = 7 pool-1-thread-4
	 * End. pool-1-thread-4 Start. Command = 8 pool-1-thread-3 End.
	 * pool-1-thread-3 Start. Command = 9 pool-1-thread-2 End. pool-1-thread-1
	 * End. pool-1-thread-5 End. pool-1-thread-4 End. pool-1-thread-3 End.
	 * 
	 * 
	 */
	private void testFun() {
		ExecutorService executor = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {
			Runnable worker = new DemoThread("" + i);
			executor.execute(worker);
		}

		executor.shutdown();

		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}

	private void testSeachKeyword() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");
		String directory = in.nextLine();
		System.out.print("Enter keyword (e.g. volatile): ");
		String keyword = in.nextLine();

		ExecutorService pool = Executors.newCachedThreadPool();

		PoolMatchCounter counter = new PoolMatchCounter(new File(directory),
				keyword, pool);
		Future<Integer> result = pool.submit(counter);

		try {
			System.out.println(result.get() + " matching files.");
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
		}
		pool.shutdown();

		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("largest pool size=" + largestPoolSize);
	}
}

/**
 * This task counts the files in a directory and its subdirectories that contain
 * a given keyword.
 */
class PoolMatchCounter implements Callable<Integer> {
	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;

	/**
	 * Constructs a MatchCounter.
	 * 
	 * @param directory
	 *            the directory in which to start the search
	 * @param keyword
	 *            the keyword to look for
	 * @param pool
	 *            the thread pool for submitting subtasks
	 */
	public PoolMatchCounter(File directory, String keyword, ExecutorService pool) {
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	public Integer call() {
		count = 0;
		try {
			File[] files = directory.listFiles();
			ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();

			for (File file : files)
				if (file.isDirectory()) {
					PoolMatchCounter counter = new PoolMatchCounter(file,
							keyword, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				} else {
					if (search(file))
						count++;
				}

			for (Future<Integer> result : results)
				try {
					count += result.get();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
		} catch (InterruptedException e) {
		}
		return count;
	}

	/**
	 * Searches a file for a given keyword.
	 * 
	 * @param file
	 *            the file to search
	 * @return true if the keyword is contained in the file
	 */
	public boolean search(File file) {
		try {
			Scanner in = new Scanner(new FileInputStream(file));
			boolean found = false;
			while (!found && in.hasNextLine()) {
				String line = in.nextLine();
				if (line.contains(keyword))
					found = true;
			}
			in.close();
			return found;
		} catch (IOException e) {
			return false;
		}
	}
}

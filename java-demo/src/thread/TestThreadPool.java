package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
	A thread pool manages the pool of worker threads, 
	it contains a queue that keeps tasks waiting to get executed.

	A thread pool manages the collection of Runnable threads and worker threads execute Runnable from the queue.

	pool-1-thread-1 Start. Command = 0
	pool-1-thread-2 Start. Command = 1
	pool-1-thread-5 Start. Command = 4
	pool-1-thread-3 Start. Command = 2
	pool-1-thread-4 Start. Command = 3
	pool-1-thread-2 End.
	pool-1-thread-2 Start. Command = 5
	pool-1-thread-1 End.
	pool-1-thread-1 Start. Command = 6
	pool-1-thread-5 End.
	pool-1-thread-5 Start. Command = 7
	pool-1-thread-4 End.
	pool-1-thread-4 Start. Command = 8
	pool-1-thread-3 End.
	pool-1-thread-3 Start. Command = 9
	pool-1-thread-2 End.
	pool-1-thread-1 End.
	pool-1-thread-5 End.
	pool-1-thread-4 End.
	pool-1-thread-3 End.

 *
 */
public class TestThreadPool {

	public static void main(String[] args) {
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

}

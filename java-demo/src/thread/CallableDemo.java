package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo implements Callable<String> {
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);

		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}

	public static void main(String args[]) {
		// scenario1();

		scenario2();
	}

	private static void scenario1() {
		// Get ExecutorService from Executors utility class, thread pool size is
		// 10
		ExecutorService executor = Executors.newFixedThreadPool(10);

		// create a list to hold the Future object associated with Callable
		List<Future<String>> list = new ArrayList<Future<String>>();

		// Create MyCallable instance
		Callable<String> callable = new CallableDemo();

		for (int i = 0; i < 100; i++) {
			// submit Callable tasks to be executed by thread pool
			Future<String> future = executor.submit(callable);

			// add Future to the list, we can get return value using Future
			list.add(future);
		}
		for (Future<String> fut : list) {
			try {
				// print the return value of Future, notice the output delay in
				// console
				// because Future.get() waits for task to get completed
				System.out.println(new Date() + "::" + fut.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		// shut down the executor service now
		executor.shutdown();
	}

	private static void scenario2() {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++)
			results.add(exec.submit(new TaskWithResult(i)));

		for (Future<String> fs : results)
			try {
				// get() blocks until completion:
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
	}
}

class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() {
		return "result of TaskWithResult " + id;
	}
}
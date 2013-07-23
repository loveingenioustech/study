package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 If you will run above program, you will notice that count value varies
 between 5,6,7,8. The reason is because count++ is not an atomic operation. So
 by the time one threads read it’s value and increment it by one, other thread
 has read the older value leading to wrong result.
 
 
 To solve this issue, we will have to make sure that increment operation on count is atomic,
 we can do that using Synchronization but Java 5 java.util.concurrent.atomic provides wrapper classes 
 for int and long that can be used to achieve this atomically without usage of Synchronization. 
  
  
 * 
 */
public class TestAtomic {

	public static void main(String[] args) throws InterruptedException {
		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());

		SafetyProcessingThread spt = new SafetyProcessingThread();
		Thread t3 = new Thread(spt, "t3");
		t3.start();

		Thread t4 = new Thread(spt, "t4");
		t4.start();

		t3.join();
		t4.join();
		System.out.println("Safety Processing count=" + spt.getCount());
	}

}

class ProcessingThread implements Runnable {
	private int count;

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			processSomething(i);
			count++;
		}
	}

	public int getCount() {
		return this.count;
	}

	private void processSomething(int i) {
		// processing some job
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class SafetyProcessingThread implements Runnable {
	private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			processSomething(i);
			count.incrementAndGet();
		}
	}

	public int getCount() {
		return this.count.get();
	}

	private void processSomething(int i) {
		// processing some job
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package thread;

import java.text.SimpleDateFormat;
import java.util.Random;

/**

Thread Name= 0 default Formatter = yyyyMMdd HHmm
Thread Name= 0 formatter = M/d/yy h:mm a
Thread Name= 1 default Formatter = yyyyMMdd HHmm
Thread Name= 2 default Formatter = yyyyMMdd HHmm
Thread Name= 1 formatter = M/d/yy h:mm a
Thread Name= 3 default Formatter = yyyyMMdd HHmm
Thread Name= 4 default Formatter = yyyyMMdd HHmm
Thread Name= 5 default Formatter = yyyyMMdd HHmm
Thread Name= 3 formatter = M/d/yy h:mm a
Thread Name= 4 formatter = M/d/yy h:mm a
Thread Name= 2 formatter = M/d/yy h:mm a
Thread Name= 6 default Formatter = yyyyMMdd HHmm
Thread Name= 5 formatter = M/d/yy h:mm a
Thread Name= 7 default Formatter = yyyyMMdd HHmm
Thread Name= 7 formatter = M/d/yy h:mm a
Thread Name= 6 formatter = M/d/yy h:mm a
Thread Name= 8 default Formatter = yyyyMMdd HHmm
Thread Name= 9 default Formatter = yyyyMMdd HHmm
Thread Name= 8 formatter = M/d/yy h:mm a
Thread Name= 9 formatter = M/d/yy h:mm a

As you can see from the output that Thread-0 has changed the value of formatter 
but still thread-2 default formatter is same as the initialized value.
 *
 */
public class TestThreadLocal implements Runnable {

	// SimpleDateFormat is not thread-safe, so give one to each thread
	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}
	};

	public static void main(String[] args) throws InterruptedException {
		TestThreadLocal obj = new TestThreadLocal();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(obj, "" + i);
			Thread.sleep(new Random().nextInt(1000));
			t.start();
		}
	}

	@Override
	public void run() {
		System.out.println("Thread Name= " + Thread.currentThread().getName()
				+ " default Formatter = " + formatter.get().toPattern());
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		formatter.set(new SimpleDateFormat());
		System.out.println("Thread Name= " + Thread.currentThread().getName()
				+ " formatter = " + formatter.get().toPattern());
	}

}

package thread;

import java.util.concurrent.BlockingQueue;

public class DemoProducer implements Runnable {

	private BlockingQueue<DemoMessage> queue;

	public DemoProducer(BlockingQueue<DemoMessage> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		// produce messages
		for (int i = 0; i < 100; i++) {
			DemoMessage msg = new DemoMessage("" + i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// adding exit message
		DemoMessage msg = new DemoMessage("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

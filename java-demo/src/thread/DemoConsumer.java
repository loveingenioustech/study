package thread;

import java.util.concurrent.BlockingQueue;

public class DemoConsumer implements Runnable {

	private BlockingQueue<DemoMessage> queue;

	public DemoConsumer(BlockingQueue<DemoMessage> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			DemoMessage msg;
			// consuming DemoMessages until exit DemoMessage is received
			while ((msg = queue.take()).getMsg() != "exit") {
				Thread.sleep(10);
				System.out.println("Consumed " + msg.getMsg());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

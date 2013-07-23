package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**

put(E e): This method is used to insert elements to the queue, if the queue is full it waits for the space to be available.
E take(): This method retrieves and remove the element from the head of the queue, if queue is empty it waits for the element to be available.
Let’s implement producer consumer problem using BlockingQueue now.
 *
 */
public class TestProducerConsumerService {

	public static void main(String[] args) {
		// Creating BlockingQueue of size 10
		BlockingQueue<DemoMessage> queue = new ArrayBlockingQueue<DemoMessage>(
				10);
		
		DemoProducer producer = new DemoProducer(queue);
		DemoConsumer consumer = new DemoConsumer(queue);
		
		// starting producer to produce messages in queue
		new Thread(producer).start();
		
		// starting consumer to consume messages from queue
		new Thread(consumer).start();
		
		System.out.println("Producer and Consumer has been started");
	}
}

package collection;

import java.util.*;

/**
 * This program demonstrates the use of a priority queue.
 */
public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueueDemo demo = new PriorityQueueDemo();

		// demo.test1();

		demo.test2();
	}

	private void test1() {
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
		pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9)); // G. Hopper
		pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10)); // A.
																	// Lovelace
		pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3)); // J. von
																	// Neumann
		pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22)); // K. Zuse

		System.out.println("Iterating over elements...");

		for (GregorianCalendar date : pq)
			System.out.println(date.get(Calendar.YEAR));

		System.out.println("Removing elements...");
		while (!pq.isEmpty())
			System.out.println(pq.remove().get(Calendar.YEAR));
	}

	private void test2() {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++)
			priorityQueue.offer(rand.nextInt(i + 10));
		QueueDemo.printQ(priorityQueue);

		List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2,
				3, 9, 14, 18, 21, 23, 25);
		
		priorityQueue = new PriorityQueue<Integer>(ints);
		QueueDemo.printQ(priorityQueue);
		
		priorityQueue = new PriorityQueue<Integer>(ints.size(),
				Collections.reverseOrder());
		priorityQueue.addAll(ints);
		
		QueueDemo.printQ(priorityQueue);

		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));
		PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
		QueueDemo.printQ(stringPQ);
		stringPQ = new PriorityQueue<String>(strings.size(),
				Collections.reverseOrder());
		stringPQ.addAll(strings);
		QueueDemo.printQ(stringPQ);

		Set<Character> charSet = new HashSet<Character>();
		for (char c : fact.toCharArray())
			charSet.add(c); // Autoboxing
		PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(
				charSet);
		QueueDemo.printQ(characterPQ);

	}

}

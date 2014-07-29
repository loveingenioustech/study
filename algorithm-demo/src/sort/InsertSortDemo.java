package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import stdlib.StdOut;

public class InsertSortDemo {

	public static void main(String[] args) {
		InsertSortDemo demo = new InsertSortDemo();

		List numbers = new ArrayList();
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
		numbers.add(8);
		numbers.add(2);
		numbers.add(1);

		List sortedList = demo.insertSort(numbers);
		StdOut.print(sortedList);
	}

	public static List<Integer> insertSort(final List<Integer> numbers) {
		final List<Integer> sortedList = new LinkedList<Integer>();
		originalList: for (Integer number : numbers) {
			for (int i = 0; i < sortedList.size(); i++) {
				if (number < sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		return sortedList;
	}
}

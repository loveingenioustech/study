package sort;

import java.util.ArrayList;
import java.util.List;

import stdlib.StdOut;

public class QuickSortDemo {

	public static void main(String[] args) {
		QuickSortDemo demo = new QuickSortDemo();

		List numbers = new ArrayList();
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
		numbers.add(8);
		numbers.add(2);
		numbers.add(1);

		List sortedList = demo.quicksort(numbers);
		StdOut.print(sortedList);
	}

	public static List<Integer> quicksort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers;
		}
		final Integer pivot = numbers.get(0);
		final List<Integer> lower = new ArrayList<Integer>();
		final List<Integer> higher = new ArrayList<Integer>();
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i) < pivot) {
				lower.add(numbers.get(i));
			} else {
				higher.add(numbers.get(i));
			}
		}
		final List<Integer> sorted = quicksort(lower);
		sorted.add(pivot);
		sorted.addAll(quicksort(higher));
		return sorted;
	}
}

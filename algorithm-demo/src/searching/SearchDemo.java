package searching;

import java.util.ArrayList;
import java.util.List;

import stdlib.StdOut;

public class SearchDemo {

	public static void main(String[] args) {
		List numbers = new ArrayList();
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
		numbers.add(8);
		numbers.add(2);
		numbers.add(1);

		StdOut.println(binarySearch(numbers, 8));
		StdOut.println(binarySearch(numbers, 10));
		
	}

	public static boolean binarySearch(final List<Integer> numbers,
			final Integer value) {
		if (numbers == null || numbers.isEmpty()) {
			return false;
		}
		final Integer comparison = numbers.get(numbers.size() / 2);
		if (value.equals(comparison)) {
			return true;
		}
		if (value < comparison) {
			return binarySearch(numbers.subList(0, numbers.size() / 2), value);
		} else {
			return binarySearch(
					numbers.subList(numbers.size() / 2 + 1, numbers.size()),
					value);
		}
	}
}

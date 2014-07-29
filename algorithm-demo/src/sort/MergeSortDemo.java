package sort;

import java.util.ArrayList;
import java.util.List;

import stdlib.StdOut;

public class MergeSortDemo {

	public static void main(String[] args) {
		MergeSortDemo demo = new MergeSortDemo();

		List numbers = new ArrayList();
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
		numbers.add(8);
		numbers.add(2);
		numbers.add(1);

		List sortedList = demo.mergesort(numbers);
		StdOut.print(sortedList);
	}

	public static List<Integer> mergesort(final List<Integer> values) {
		if (values.size() < 2) {
			return values;
		}
		final List<Integer> leftHalf = values.subList(0, values.size() / 2);
		final List<Integer> rightHalf = values.subList(values.size() / 2,
				values.size());
		return merge(mergesort(leftHalf), mergesort(rightHalf));
	}

	private static List<Integer> merge(final List<Integer> left,
			final List<Integer> right) {
		int leftPtr = 0;
		int rightPtr = 0;
		final List<Integer> merged =

		new ArrayList<Integer>(left.size() + right.size());

		while (leftPtr < left.size() && rightPtr < right.size()) {
			if (left.get(leftPtr) < right.get(rightPtr)) {
				merged.add(left.get(leftPtr));
				leftPtr++;
			} else {
				merged.add(right.get(rightPtr));
				rightPtr++;
			}
		}
		while (leftPtr < left.size()) {
			merged.add(left.get(leftPtr));
			leftPtr++;
		}
		while (rightPtr < right.size()) {
			merged.add(right.get(rightPtr));
			rightPtr++;
		}
		return merged;
	}
}

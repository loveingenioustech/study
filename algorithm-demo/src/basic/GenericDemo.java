package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import stdlib.StdOut;

public class GenericDemo {

	public static void main(String[] args) {
		GenericDemo demo = new GenericDemo();

		List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, -8);

		StdOut.println("addOne");
		StdOut.print(demo.addOne(numbers));

		StdOut.println("updateList");
		StdOut.print(demo.updateList(numbers, new IntegerOperation() {

			@Override
			public Integer performOperation(Integer value) {
				return Math.abs(value);
			}
		}));

		StdOut.println("stringLengths");
		demo.stringLengths();		
	}

	public List<Integer> addOne(final List<Integer> numbers) {
		final ArrayList<Integer> toReturn = new ArrayList<Integer>(
				numbers.size());
		for (final Integer number : numbers) {
			toReturn.add(number + 1);
		}
		return toReturn;
	}

	public List<Integer> updateList(final List<Integer> numbers,
			final IntegerOperation op) {
		final ArrayList<Integer> toReturn = new ArrayList<Integer>(
				numbers.size());
		for (final Integer number : numbers) {
			toReturn.add(op.performOperation(number));
		}
		return toReturn;
	}

	public <A, B> List<B> mapList(final List<A> values,
			final GenericOperation<A, B> op) {
		final ArrayList<B> toReturn = new ArrayList<B>(values.size());
		for (final A a : values) {
			toReturn.add(op.performOperation(a));
		}
		return toReturn;
	}

	public void stringLengths() {
		final List<String> strings = Arrays.asList("acing", "the", "java",
				"interview");
		final List<Integer> expected = Arrays.asList(5, 3, 4, 9);
		final List<Integer> actual = this.mapList(strings,
				new StringLengthOperation());
		StdOut.println(actual);
	}
}

package sort;

import java.util.Arrays;

import stdlib.StdOut;

public class NaturallySortDemo {

	public static void main(String[] args) {
		NaturallySortDemo demo = new NaturallySortDemo();
		demo.sortInts();
		
		demo.sortObjects();
	}

	public void sortInts() {
		final int[] numbers = { -3, -5, 1, 7, 4, -2 };
		final int[] expected = { -5, -3, -2, 1, 4, 7 };
		Arrays.sort(numbers);
		StdOut.print(numbers);
	}

	public void sortObjects() {
		final String[] strings = { "z", "x", "y", "abc", "zzz", "zazzy" };
		final String[] expected = { "abc", "x", "y", "z", "zazzy", "zzz" };
		Arrays.sort(strings);
		StdOut.print(strings);
	}
}

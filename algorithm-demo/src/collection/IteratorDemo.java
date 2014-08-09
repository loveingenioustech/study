package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import stdlib.StdOut;

public class IteratorDemo {

	public static void main(String[] args) {
		IteratorDemo demo = new IteratorDemo();
		demo.multipleIterators();
	}

	public void multipleIterators() {
		final Iterator<Integer> a = Arrays.asList(1, 2, 3, 4, 5).iterator();
		final Iterator<Integer> b = Arrays.asList(6).iterator();
		final Iterator<Integer> c = new ArrayList<Integer>().iterator();
		final Iterator<Integer> d = new ArrayList<Integer>().iterator();
		final Iterator<Integer> e = Arrays.asList(7, 8, 9).iterator();

		final Iterator<Integer> singleIterator = new ListIterator(
				Arrays.asList(a, b, c, d, e));

		StdOut.println(singleIterator.hasNext());
		for (Integer i = 1; i <= 9; i++) {
			StdOut.println("i = " + i + " singleIterator.next() = "
					+ singleIterator.next());
		}
		StdOut.println(singleIterator.hasNext());
	}

}

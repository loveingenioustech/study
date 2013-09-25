package collection;

import static util.Print.print;

import java.util.Arrays;

import util.ConvertTo;
import util.Generated;
import util.Generator;
import util.RandomGenerator;

public class ArrayDemo {

	public static void main(String[] args) {
		ArrayDemo arrayDemo = new ArrayDemo();

		arrayDemo.alphabeticSearch();

		arrayDemo.searching();
	}

	private void alphabeticSearch() {
		String[] sa = Generated.array(new String[30],
				new RandomGenerator.String(5));

		Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);

		System.out.println(Arrays.toString(sa));

		int index = Arrays.binarySearch(sa, sa[10],
				String.CASE_INSENSITIVE_ORDER);
		System.out.println("Index: " + index + "\n" + sa[index]);
	}

	private void searching() {
		Generator<Integer> gen = new RandomGenerator.Integer(1000);
		int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
		Arrays.sort(a);
		print("Sorted array: " + Arrays.toString(a));
		
		while (true) {
			int r = gen.next();
			int location = Arrays.binarySearch(a, r);
			if (location >= 0) {
				print("Location of " + r + " is " + location + ", a["
						+ location + "] = " + a[location]);
				break; // Out of while loop
			}
		}

	}
}

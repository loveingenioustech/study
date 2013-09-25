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

		// arrayDemo.alphabeticSearch();

		// arrayDemo.searching();

		// arrayDemo.assemblingMultidimensionalArrays();

		// arrayDemo.comparingArrays();

		// arrayDemo.copyingArrays();

		arrayDemo.fillingArrays();
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

	private void assemblingMultidimensionalArrays() {
		Integer[][] a;
		a = new Integer[3][];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Integer[3];
			for (int j = 0; j < a[i].length; j++)
				a[i][j] = i * j; // Autoboxing
		}

		System.out.println(Arrays.deepToString(a));
	}

	private void comparingArrays() {
		int[] a1 = new int[10];
		int[] a2 = new int[10];

		Arrays.fill(a1, 47);
		Arrays.fill(a2, 47);

		print(Arrays.equals(a1, a2));

		a2[3] = 11;
		print(Arrays.equals(a1, a2));

		String[] s1 = new String[4];
		Arrays.fill(s1, "Hi");
		String[] s2 = { new String("Hi"), new String("Hi"), new String("Hi"),
				new String("Hi") };

		print(Arrays.equals(s1, s2));
	}

	private void copyingArrays() {
		int[] i = new int[7];
		int[] j = new int[10];
		Arrays.fill(i, 47);
		Arrays.fill(j, 99);

		print("i = " + Arrays.toString(i));
		print("j = " + Arrays.toString(j));
		System.arraycopy(i, 0, j, 0, i.length);

		print("j = " + Arrays.toString(j));

		int[] k = new int[5];
		Arrays.fill(k, 103);
		System.arraycopy(i, 0, k, 0, k.length);
		print("k = " + Arrays.toString(k));

		Arrays.fill(k, 103);
		System.arraycopy(k, 0, i, 0, k.length);
		print("i = " + Arrays.toString(i));

		// Objects:
		Integer[] u = new Integer[10];
		Integer[] v = new Integer[5];

		Arrays.fill(u, new Integer(47));
		Arrays.fill(v, new Integer(99));
		print("u = " + Arrays.toString(u));
		print("v = " + Arrays.toString(v));
		System.arraycopy(v, 0, u, u.length / 2, v.length);
		print("u = " + Arrays.toString(u));
	}

	private void fillingArrays() {
		int size = 6;
		boolean[] a1 = new boolean[size];
		byte[] a2 = new byte[size];
		char[] a3 = new char[size];
		short[] a4 = new short[size];
		int[] a5 = new int[size];
		long[] a6 = new long[size];
		float[] a7 = new float[size];
		double[] a8 = new double[size];
		String[] a9 = new String[size];
		Arrays.fill(a1, true);
		print("a1 = " + Arrays.toString(a1));
		Arrays.fill(a2, (byte) 11);
		print("a2 = " + Arrays.toString(a2));
		Arrays.fill(a3, 'x');
		print("a3 = " + Arrays.toString(a3));
		Arrays.fill(a4, (short) 17);
		print("a4 = " + Arrays.toString(a4));
		Arrays.fill(a5, 19);
		print("a5 = " + Arrays.toString(a5));
		Arrays.fill(a6, 23);
		print("a6 = " + Arrays.toString(a6));
		Arrays.fill(a7, 29);
		print("a7 = " + Arrays.toString(a7));
		Arrays.fill(a8, 47);
		print("a8 = " + Arrays.toString(a8));
		Arrays.fill(a9, "Hello");
		print("a9 = " + Arrays.toString(a9));
		// Manipulating ranges:
		Arrays.fill(a9, 3, 5, "World");
		print("a9 = " + Arrays.toString(a9));
	}

}

package collection;

import java.util.Arrays;

import util.Generated;
import util.RandomGenerator;

public class ArrayDemo {

	public static void main(String[] args) {
		ArrayDemo arrayDemo = new ArrayDemo();

		arrayDemo.alphabeticSearch();
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

}

package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicatesFromArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ArrayList with duplicates String
		List<String> duplicateList = (List<String>) Arrays.asList("Android",
				"Android", "iOS", "Windows mobile");
		// should print 4 becaues of duplicates Android
		System.out.println("size of Arraylist with duplicates: "
				+ duplicateList.size());
		System.out.println("ArrayList with duplicates: " + duplicateList);

		// Converting ArrayList to HashSet to remove duplicates
		LinkedHashSet<String> listToSet = new LinkedHashSet<String>(
				duplicateList);

		// Creating Arraylist without duplicate values
		List<String> listWithoutDuplicates = new ArrayList<String>(listToSet);
		// should print 3 becaues of duplicates Android removed
		System.out.println("size of ArrayList without duplicates: "
				+ listToSet.size());
		System.out
				.println("ArrayList after removing duplicates in same order: "
						+ listWithoutDuplicates);

	}

}

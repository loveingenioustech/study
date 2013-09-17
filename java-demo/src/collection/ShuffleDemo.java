package collection;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 */
public class ShuffleDemo {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 49; i++)
			numbers.add(i);
		
		Collections.shuffle(numbers);
		
		List<Integer> winningCombination = numbers.subList(0, 6);
		
		Collections.sort(winningCombination);
		System.out.println(winningCombination);
	}
}

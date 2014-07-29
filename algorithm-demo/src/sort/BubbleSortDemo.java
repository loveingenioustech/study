package sort;

import stdlib.StdOut;

public class BubbleSortDemo {

	public static void main(String[] args) {
		BubbleSortDemo demo = new BubbleSortDemo();

		int[] numbers = { 1, 3, 8, 2, 9, 4 };
		demo.bubbleSort(numbers);

		StdOut.print(numbers);
	}

	public void bubbleSort(int[] numbers) {
		boolean numbersSwitched;
		do {
			numbersSwitched = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i + 1] < numbers[i]) {
					int tmp = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = tmp;
					numbersSwitched = true;
				}
			}
		} while (numbersSwitched);
	}
}

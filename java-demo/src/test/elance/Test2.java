/**
 *
Write a program which will print the below structures according to the input provided to the program. The program should accept 3 inputs in the form of numbers between 1 and 9, both inclusive (one number per line) and then generate the corresponding structures based on the input.

Suppose the following sequence of numbers is supplied to the program:

3
2
4

Then the output should be:

  1
 2 2
3 3 3
 1
2 2
   1
  2 2
 3 3 3
4 4 4 4
 *
 */
package test.elance;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int arr[] = new int[3];
		arr[0] = in.nextInt();
		arr[1] = in.nextInt();
		arr[2] = in.nextInt();
		for (int i = 0; i < arr.length; i++) {
			int y = arr[i];
			int z = y + 1;
			for (int j = 1; j <= y; j++) {
				System.out.println();
				System.out.format("%" + z + "s", "");
				for (int k = 1; k <= j; k++) {
					System.out.print(j);
					System.out.format("%1s", "");
				}
				z--;
			}
		}

	}
}

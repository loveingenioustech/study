package test.elance;

import java.util.Scanner;

/**
 *
Write a program which will accept a single pair of strings separated by a comma; 
	the program should calculate the sum of ascii values of the characters of each string. 
	The program should then subtract the sum of the ascii values of the second string from the sum of the ascii values of the first string.

Suppose the following input is given to the program:

123ABC,456DEF

Then the sum of the ascii values of the characters in '123ABC' is 348 and in '456DEF' it is 366. The Difference between these numbers is 348 – 366 = -18
The corresponding output to be printed by the program is:

-18

 *
 */
public class Test7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean condition = false;

		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();
		condition = value.equalsIgnoreCase("exit");
		if (!condition && value.contains(",")) {
			calculate(value);
		}
	}

	private static void calculate(String value) {
		final String[] event1 = value.split(",");
		int ss = 0;
		for (int i = 0; i < event1[0].length(); ++i) {
			char c = event1[0].charAt(i);
			ss += (int) c;
		}
		int sd = 0;
		for (int i = 0; i < event1[1].length(); ++i) {
			char c = event1[1].charAt(i);
			sd += (int) c;
		}
		System.out.println(ss - sd);
	}

}

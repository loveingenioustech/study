/**
 *
Write a program which will accept three sentences (one sentence per line) and print the words having Initial Caps within the sentences. Below is an example.

Here is an example. If the below three sentences are given to the program as input,

This is a Program
Coding test of Initial Caps
the program Will Test You

Then, the output would look like:

This
Program
Coding
Initial
Caps
Will
Test
You
 *
 */
package test.elance;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test5 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String li[] = new String[3];
		li[0] = in.nextLine();
		li[1] = in.nextLine();
		li[2] = in.nextLine();
		capsOut(li[0]);
		capsOut(li[1]);
		capsOut(li[2]);

	}

	public static void capsOut(String in) {
		String words[] = in.split(" ");
		for (String word : words) {
			Pattern pat = Pattern.compile("^[A-Z]");
			Matcher match = pat.matcher(word);
			if (match.find())
				System.out.println(word);
		}

	}
}

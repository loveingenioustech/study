/**
 *
Sam wants to select a username in order to register on a website.

The rules for selecting a username are:

1. The minimum length of the username must be 5 characters and the maximum may be 10.
2. It should contain at least one letter from A-Z
3. It should contain at least one digit from 0-9
4. It should contain at least one character from amongst @#*=
5. It should not contain any spaces

Write a program which accepts 4 usernames (one username per line) as input and checks whether each of them satisfy the above mentioned conditions.
If a username satisfies the conditions, the program should print PASS (in uppercase)
If a username fails the conditions, the program should print FAIL (in uppercase)

Suppose the following usernames are supplied to the program:
1234@a
ABC3a#@
1Ac@
ABC 3a#@

Then the output should be:
FAIL
PASS
FAIL
FAIL

IMPORTANT NOTES - READ CAREFULLY:

1. Your solution should assume console input

2. Your solution should contain class name as Main, as the solution will be compiled as Main.java 

 *
 */
package test.elance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Test3 {

	/**
	 * 
	 */
	private static Pattern pat = Pattern.compile("[A-Z]+");
	private static Pattern pat2 = Pattern.compile("[0-9]+");

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));

		String n1 = bufferRead.readLine();
		String n2 = bufferRead.readLine();
		String n3 = bufferRead.readLine();
		String n4 = bufferRead.readLine();
		
		// String n1 = "1234@a";
		// String n2 = "ABC3a#@";
		// String n3 = "1Ac@";
		// String n4 = "ABC 3a#@";

		System.out.println(verifyUserName(n1));
		System.out.println(verifyUserName(n2));
		System.out.println(verifyUserName(n3));
		System.out.println(verifyUserName(n4));		
	}

	public static String verifyUserName(String name) {

		boolean isLenghtOk = (name.length() >= 5 && name.length() <= 10);
		boolean isNoSpaceOk = name.indexOf(" ") == -1;
		boolean isConainCapitalOk = pat.matcher(name).find();
		boolean isDigitOk = pat2.matcher(name).find();

		boolean ok = isConainCapitalOk && isNoSpaceOk && isDigitOk
				&& isLenghtOk;
		return ok ? "PASS" : "FAIL";

	}

}

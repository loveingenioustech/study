/**
 *
Write a program to print numbers from 258 to 393 except the number end with 5.
 *
 */

package test.elance;

public class Test9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 258; i < 394; i++) {
			String s1 = Integer.toString(i);
			char c = s1.charAt(2);
			String s2 = Character.toString(c);

			int n = Integer.parseInt(s2);
			if (n != 5) {
				System.out.println(s1);
			}
		}

	}

}

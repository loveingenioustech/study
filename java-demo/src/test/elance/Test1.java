/**
Kermit, a frog hops in a particular way such that:

1. He hops 20cm in the first hop, 10cm in the second hop and 5cm in the third hop.
2. After three hops Kermit rests for a while and then again follows the same hopping pattern.

Calculate the total distance travelled by Kermit (in centimeters) for the provided number of hops. Exactly 4 numbers of hops will be provided to the program (one number per line) as per the below example.

Suppose the following number of hops is provided to the program:
4
6
3
5
Then the total distance covered should be displayed as follows:
55
70
35
65
 */
package test.elance;

import java.util.Scanner;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a, b, c, d;
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		b = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		int[] array = { a, b, c, d };
		int k = 0;

		for (int i = 0; i < array.length; i++) {
			switch (array[i] % 3) {
			case 0:
				k = 0 + (array[i] / 3) * 35;
				break;
			case 1:
				k = 20 + (array[i] / 3) * 35;
				break;
			case 2:
				k = 30 + (array[i] / 3) * 35;
				break;
			case 3:
				k = 35 + (array[i] / 3) * 35;
				break;
			}
			System.out.println(k);
		}
	}

}

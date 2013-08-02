package type;

public class TestString {

	public static void main(String[] args) {
		System.out.println(stringToInt("999".toCharArray()));

	}

	/**
	 * Create a function that will convert a string to its integer value without
	 * using any library functions.
	 * 
	 * 
	 * Analysis Just for this example, I'll be using a C type programming
	 * syntax. Since we are dealing on the algorithm, I'll just explain it later
	 * on how does it work.
	 * 
	 * When we say library files it means all the shorthand functions will not
	 * be used.
	 */
	public static int stringToInt(char str[]) {
		int total = 0;

		for (int i = 0; i < str.length; i++) {
			if (str[i] < 48 || str[i] > 57) {
				System.out.println("One character is invalid.");
				return 0;
			} else {
				total = total * 10 + (str[i] - 48);
			}
		}
		return total;
	}
}

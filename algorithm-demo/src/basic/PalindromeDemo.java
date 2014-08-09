package basic;

import stdlib.StdOut;

public class PalindromeDemo {

	public static void main(String[] args) {
		PalindromeDemo demo = new PalindromeDemo();

		String text1 = "level";
		String text2 = "swot";
		String text3 = "top spot";

		StdOut.println("level is palindrome: " + demo.isPalindrome(text1));
		StdOut.println("swot is palindrome: " + demo.isPalindrome(text2));
		StdOut.println("top spot is palindrome: " + demo.isPalindrome(text3));
		StdOut.println("top spot is palindrome(strict mode): "
				+ demo.strictPalindrome(text2));

	}

	public boolean isPalindrome(final String s) {
		final String toCheck = s.toLowerCase();
		int left = 0;
		int right = toCheck.length() - 1;
		while (left <= right) {
			while (left < toCheck.length()
					&& !Character.isLetter(toCheck.charAt(left))) {
				left++;
			}
			while (right > 0 && !Character.isLetter(toCheck.charAt(right))) {
				right--;
			}
			if (left > toCheck.length() || right < 0) {
				return false;
			}
			if (toCheck.charAt(left) != toCheck.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public boolean strictPalindrome(final String s) {
		ReverseDemo rd = new ReverseDemo();
		return s.equals(rd.reverse(s));
	}
}

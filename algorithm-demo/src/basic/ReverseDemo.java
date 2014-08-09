package basic;

import stdlib.StdOut;

public class ReverseDemo {

	public static void main(String[] args) {
		ReverseDemo demo = new ReverseDemo();

		String originalText = "abcde";
		StdOut.println("reverse: " + demo.reverse(originalText));
		StdOut.println("inPlaceReverse: " + demo.inPlaceReverse(originalText));
		StdOut.println("nativeReverse: " + demo.nativeReverse(originalText));

		demo.reverseLinkedList();
	}

	public String reverse(final String s) {
		final StringBuilder builder = new StringBuilder(s.length());
		for (int i = s.length() - 1; i >= 0; i--) {
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}

	public String inPlaceReverse(final String s) {
		final StringBuilder builder = new StringBuilder(s);
		for (int i = 0; i < builder.length() / 2; i++) {
			final char tmp = builder.charAt(i);
			final int otherEnd = builder.length() - i - 1;
			builder.setCharAt(i, builder.charAt(otherEnd));
			builder.setCharAt(otherEnd, tmp);
		}
		return builder.toString();
	}

	public String nativeReverse(final String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public void reverseLinkedList() {
		final ReverseLinkedList<String> three = new ReverseLinkedList<String>(
				"3", null);
		final ReverseLinkedList<String> two = new ReverseLinkedList<String>(
				"2", three);
		final ReverseLinkedList<String> one = new ReverseLinkedList<String>(
				"1", two);
		final ReverseLinkedList<String> reversed = ReverseLinkedList
				.reverse(one);
		StdOut.println(reversed.getElement());
		StdOut.println(reversed.getNext().getElement());
		StdOut.println(reversed.getNext().getNext().getElement());
	}

}

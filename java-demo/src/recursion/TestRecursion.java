package recursion;

public class TestRecursion {

	public static void main(String[] args) {
		loopLike(1);
	}

	public static void loopLike(int n) {
		if (n > 100) {
			// Do nothing
		} else {
			System.out.println("Hello World\n" + n);
			loopLike(n + 1);
		}

	}

}

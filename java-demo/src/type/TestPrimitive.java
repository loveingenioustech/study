package type;

public class TestPrimitive {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		useWrapper();

		long endTime = System.currentTimeMillis();

		System.out
				.println("Time used for useWrapper: " + (endTime - startTime));

		startTime = System.currentTimeMillis();

		usePrimitive();

		endTime = System.currentTimeMillis();

		System.out.println("Time used for usePrimitive: "
				+ (endTime - startTime));
	}

	private static void usePrimitive() {
		long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

	private static void useWrapper() {
		Long sum = 0L; // uses Long, not long
		for (long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}

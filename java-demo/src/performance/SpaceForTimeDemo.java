package performance;

import java.util.concurrent.TimeUnit;

public class SpaceForTimeDemo {
	
	private int[] FACTORIAL_ARRAY = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	public static void main(String[] args) {
		SpaceForTimeDemo spaceForTimeDemo = new SpaceForTimeDemo();
		
		spaceForTimeDemo.testNormalFactorial();

		spaceForTimeDemo.testBetterFactorial();
	}

	private void testBetterFactorial() {		
		long startTime = System.nanoTime();
		
		for(int i = 0, n = 10; i< n ;i++){
			System.out.println(betterCalc(i));
		}	
		
		long endTime = System.nanoTime();
		
		System.out.println("------------------ Elapsed Seconds: " + formatNano(endTime - startTime));	
	}


	private void testNormalFactorial() {
		
		long startTime = System.nanoTime();
				
		for(int i = 0, n = 10; i< n ;i++){
			System.out.println(noramlCalc(i));
		}	
		
		long endTime = System.nanoTime();
		
		System.out.println("------------------ Elapsed Seconds: " + formatNano(endTime - startTime));
	}

	private double formatNano(long input) {
		return (double)input / 1000000000.0;
//		return TimeUnit.SECONDS.convert(input, TimeUnit.NANOSECONDS);
	}

	private int noramlCalc(int value) {
		if(value < 0 || value > 10){
			throw new IllegalArgumentException();
		}
		
		if(value == 0){
			return 1;
		}else{
			return noramlCalc(value-1)*value;	
		}	
		
	}
	
	private int betterCalc(int value) {
		return FACTORIAL_ARRAY[value];
	}

}

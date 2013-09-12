package performance;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SpaceForTimeDemo {
	
	private int[] FACTORIAL_ARRAY = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

	private Map<BigInteger, BigInteger> map = new HashMap<BigInteger, BigInteger>(10000);
	
	public static void main(String[] args) {
		SpaceForTimeDemo spaceForTimeDemo = new SpaceForTimeDemo();
		
		spaceForTimeDemo.testNormalFactorial();

		spaceForTimeDemo.testBetterFactorial();
		
		// Test result: 89.406550248
		spaceForTimeDemo.testNormalBigFactorial();
		
		// Test result: 48.99915683
		spaceForTimeDemo.testBetterBigFactorial();
	}

	private void testBetterBigFactorial() {
		long startTime = System.nanoTime();

		Random random= new Random();
		
		for(int i = 0, n = 1000; i< n ;i++){			
			System.out.println(betterBigCalc(BigInteger.valueOf(random.nextInt(10000))));
		}	
		
		long endTime = System.nanoTime();
		
		System.out.println("------------------ Elapsed Seconds for testBetterBigFactorial: " + formatNano(endTime - startTime));
	}

	private void testNormalBigFactorial() {		
		long startTime = System.nanoTime();

		Random random= new Random();
		
		for(int i = 0, n = 1000; i< n ;i++){			
			System.out.println(noramlBigCalc(BigInteger.valueOf(random.nextInt(10000))));
		}	
		
		long endTime = System.nanoTime();
		
		System.out.println("------------------ Elapsed Seconds for testNormalBigFactorial: " + formatNano(endTime - startTime));		
	}



	private void testBetterFactorial() {		
		long startTime = System.nanoTime();
		
		for(int i = 0, n = 10; i< n ;i++){
			System.out.println(betterCalc(i));
		}	
		
		long endTime = System.nanoTime();
		
		System.out.println("------------------ Elapsed Seconds for testBetterFactorial: " + formatNano(endTime - startTime));	
	}


	private void testNormalFactorial() {		
		long startTime = System.nanoTime();
				
		for(int i = 0, n = 10; i< n ;i++){
			System.out.println(noramlCalc(i));
		}	
		
		long endTime = System.nanoTime();
		
		System.out.println("------------------ Elapsed Seconds for testNormalFactorial: " + formatNano(endTime - startTime));
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

	private BigInteger noramlBigCalc(BigInteger value) {
		if(value.compareTo(BigInteger.valueOf(0)) == 0){
			return BigInteger.valueOf(1);
		} else{
			BigInteger nPlusOne = value.subtract(BigInteger.valueOf(1));
			return noramlBigCalc(nPlusOne).multiply(value);			
		}		
	}
	
	private BigInteger betterBigCalc(BigInteger value) {
		if(value.compareTo(BigInteger.valueOf(0)) == 0){
			return BigInteger.valueOf(1);
		} else{
			// Load value from cache
			BigInteger factor = (BigInteger) map.get(value);
			
			if(factor != null){
				return factor;
			}
			
			BigInteger nPlusOne = value.subtract(BigInteger.valueOf(1));
			factor = betterBigCalc(nPlusOne).multiply(value);
			
			map.put(value, factor);
			
			return factor;			
		}		

	}

}

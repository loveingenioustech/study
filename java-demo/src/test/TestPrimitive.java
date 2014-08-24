package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPrimitive {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void absoluteOfMostNegativeValue() {
		final int mostNegative = Integer.MIN_VALUE;
		final int negated = Math.abs(mostNegative);
		System.out.println(mostNegative);
		System.out.println(negated);
		assertFalse("No positive equivalent of Integer.MIN_VALUE", negated > 0);
	}

}

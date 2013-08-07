package fluid;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() throws Exception {
		this.calculator = new Calculator();
		this.calculator.initScripting();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculate() {
		String formula = "2*2";
		Object actual = this.calculator.calculate(formula);
		assertNotNull(actual);
		assertTrue(actual instanceof Double);
		assertEquals(4.0, actual);
	}

}

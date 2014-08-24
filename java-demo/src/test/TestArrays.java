package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestArrays {

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
	public void arraysAsObjects() {
		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("key", new int[] { 0, 1, 2, 3, 4, 5 });
		assertTrue(mapping.get("key") instanceof int[]);
	}

	@Test
	public void arrayReferences() {
		final int[] myArray = new int[] { 0, 1, 2, 3, 4, 5 };
		int[] arrayReference2 = myArray;
		arrayReference2[5] = 99;
		assertFalse(myArray[5] == 5);
	}

}

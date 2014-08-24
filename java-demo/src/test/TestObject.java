package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestObject {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void expectNullPointerExceptionToBeThrown() {
		final String s = null;
		final int stringLength = s.length();
	}

	@Test
	public void finalReferenceChanges() {
		final int i = 42;
		// i = 43; <- uncommenting this line would result in a compiler error
		final List<String> list = new ArrayList<String>(20);
		// list = new ArrayList(50); <- uncommenting this line will result in an
		// error
		assertEquals(0, list.size());
		list.add("adding a new value into my list");
		assertEquals(1, list.size());
		list.clear();
		assertEquals(0, list.size());
	}
}

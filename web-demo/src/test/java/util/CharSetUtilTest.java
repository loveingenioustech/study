package util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CharSetUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToChinese() {
		String original = "中国人";
		// Normal used in web application
        // String name = new String(request.getParameter("username").getBytes("iso-8859-1"),"gb2312");
		System.out.println(original);
		System.out.println( CharSetUtil.toChinese(original));		
	}

}

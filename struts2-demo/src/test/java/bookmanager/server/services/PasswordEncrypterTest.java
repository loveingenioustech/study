package bookmanager.server.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordEncrypterTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncrypt() {
		System.out.println("robin: " + PasswordEncrypter.encrypt("robin"));
	}

}

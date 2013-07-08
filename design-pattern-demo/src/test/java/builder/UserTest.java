package builder;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetUser() {		
		User user1 = new User.UserBuilder("Robin", "Long").age(26).phone("12345678").address("Fake address").build();
		
		Assert.assertEquals("Robin", user1.getFirstName());
		Assert.assertEquals("Long", user1.getLastName());
	}

}

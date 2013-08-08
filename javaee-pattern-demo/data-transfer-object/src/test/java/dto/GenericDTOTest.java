package dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.CompositeValidationException;

public class GenericDTOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void construction() {

		GenericDTO dto = null;
		String description = "description";
		String name = "name";
		String numberOfPages = "numberOfPages";
		try {
			dto = new GenericDTO("Book")
					.addString(description, "Duke's Adventures")
					.addString(name, "Java").addInt(numberOfPages, 10)
					.validate();
		} catch (CompositeValidationException ex) {
			fail("Not excected " + ex);
		}
		
		int numberOfAttributes = dto.getNumberOfAttributes();
		assertEquals("Should be three", 3, numberOfAttributes);

		assertFalse("GenericDTO isn't empty", dto.isEmpty());
		Object descriptionValue = dto.get(description).getValue();
		
		assertNotNull(descriptionValue);
		assertEquals("Duke's Adventures", descriptionValue);
	}

}

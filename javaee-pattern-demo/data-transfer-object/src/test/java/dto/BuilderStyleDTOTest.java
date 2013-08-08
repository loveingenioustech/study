package dto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuilderStyleDTOTest {

	private BuilderStyleDTO builderStyleDTO;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void construct() {
		this.builderStyleDTO = new BuilderStyleDTO.Builder().
				name("Duke Stories").
				numberOfPages(10).
				build();
	}

}

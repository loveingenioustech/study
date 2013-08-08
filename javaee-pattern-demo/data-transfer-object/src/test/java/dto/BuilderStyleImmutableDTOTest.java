package dto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuilderStyleImmutableDTOTest {

	private BuilderStyleImmutableDTO dto;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		this.dto = new BuilderStyleImmutableDTO.Builder(10, "Duke Tales")
				.description("Cool book about Java and Duke").build();
	}

}

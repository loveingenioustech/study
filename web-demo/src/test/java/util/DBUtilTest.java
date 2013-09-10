package util;

import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBUtilTest {

	private DBUtil dbUtil = null;

	@Before
	public void setUp() throws Exception {
		dbUtil = new DBUtil();
	}

	@After
	public void tearDown() throws Exception {
		dbUtil.close();
	}

	@Test
	public void testGetConnection() {
		try {
			dbUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testExecuteQuery() {
		// TODO
	}

	@Test
	public void testExecuteUpdate() {
		// TODO
	}

}

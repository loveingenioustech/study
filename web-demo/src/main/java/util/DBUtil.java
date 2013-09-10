package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	private Connection conn = null;
	private ResultSet rs = null;
	private String driver;
	private String url;
	private String dbUsername;
	private String dbPassword;
	private String useConnectionPool;
	private String connectionPoolUrl;

	public DBUtil() {
		try {
			this.initProperty();

			if ("true".equals(useConnectionPool)) {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup(connectionPoolUrl);
				conn = ds.getConnection();
			} else {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void initProperty() {
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"database.properties");
		Properties dbProps = new Properties();

		try {
			dbProps.load(is);
			useConnectionPool = dbProps.getProperty("useConnectionPool");

			if (!"true".equals(useConnectionPool)) {
				driver = dbProps.getProperty("driver");
				url = dbProps.getProperty("url");
				dbUsername = dbProps.getProperty("username");
				dbPassword = dbProps.getProperty("password");
			} else {
				connectionPoolUrl = dbProps.getProperty("connectionPoolUrl");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Can not read the properties file; "
					+ "Make sure db.properties is in the Classpath");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public Connection getConnection() throws SQLException {
		return conn;
	}

	public ResultSet executeQuery(String sql) {
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		int result = 0;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

}

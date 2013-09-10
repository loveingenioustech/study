package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	Connection connect = null;
	ResultSet rs = null;

	public DBUtil() {
		try {
			// Oracle Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (java.lang.ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String sql) {
		try {
			connect = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "web_demo",
					"web_demo");
			Statement stmt = connect.createStatement(
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
			connect = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "web_demo",
					"web_demo");
			Statement stmt = connect.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return result;
	}

	public void close() {
		if (connect != null) {
			try {
				connect.close();
				connect = null;
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

}

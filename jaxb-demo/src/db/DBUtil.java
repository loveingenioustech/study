package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	/**
	 * get database connection
	 * 
	 * @return Connection
	 */
	public static Connection getDBConnection(Schema schema) throws SQLException {
		try {
			Class.forName(schema.getDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(schema.getUrl(),
				schema.getUser(), schema.getPassword());

		return connection;
	}

}
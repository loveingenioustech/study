package eclipse.mapping;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import db.Column;
import db.DBUtil;
import db.Key;
import db.Schema;
import db.Table;

public class DbToJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String tableName = "EVENT";

		DbToJava db2XML = new DbToJava();

		Table eventTable = db2XML.reverseTable(tableName);

		System.out.println(eventTable.toString());
	}

	public Table reverseTable(String tableName) {
		Properties props = new Properties();
		String driver = null;
		String url = null;
		String user = null;
		String password = null;

		try {
			String proFilePath = System.getProperty("user.dir")
					+ "/src/database.properties";
			props.load(new BufferedInputStream(new FileInputStream(proFilePath)));

			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Schema defaultSchema = new Schema(user, password, url, driver);
		return reverseTable(tableName, defaultSchema);
	}

	public Table reverseTable(String tableName, Schema schema) {
		Table table = null;
		List<Column> colList = null;
		List<Key> keyList = null;
		ResultSet rs = null;

		System.out.println("Table:" + tableName);
		try {
			Connection conn = DBUtil.getDBConnection(schema);

			DatabaseMetaData md = conn.getMetaData();
			rs = md.getColumns(null, md.getUserName(), tableName, "%");

			colList = new ArrayList<Column>();
			Column col = null;
			while (rs.next()) {
				col = new Column();
				col.setName(rs.getString("COLUMN_NAME"));
				col.setType(rs.getString("TYPE_NAME"));
				col.setNullAble(rs.getInt("NULLABLE") == 1);
				col.setSize(rs.getInt("COLUMN_SIZE"));
				col.setDecimalDigits(rs.getInt("DECIMAL_DIGITS"));
				col.setNullAble(rs.getInt("NULLABLE") == 1);
				colList.add(col);
			}

			rs = md.getPrimaryKeys(null, md.getUserName(), tableName);
			keyList = new ArrayList<Key>();
			Key key = null;
			while (rs.next()) {
				key = new Key();
				key.setColumnName(rs.getString("COLUMN_NAME"));
				key.setKeySeq(rs.getShort("KEY_SEQ"));
				key.setPkName(rs.getString("PK_NAME"));
				keyList.add(key);
			}

			table = new Table();
			table.setName(tableName);

			if (colList != null && colList.size() > 0) {
				table.setColumns(colList);
			}

			if (keyList != null && keyList.size() > 0) {
				table.setKeies(keyList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return table;
	}

}

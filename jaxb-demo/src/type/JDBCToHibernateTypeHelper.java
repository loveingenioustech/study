package type;

import java.util.HashMap;
import java.util.Map;

public final class JDBCToHibernateTypeHelper {

	private JDBCToHibernateTypeHelper() {
	}

	/** The Map containing the preferred conversion type values. */
	private static final Map PREFERRED_HIBERNATETYPE_FOR_ORACLE = new HashMap();

	static {
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("CHAR", "char");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("DATE", "date");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("FLOAT", "double");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("LONG", "string");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("NUMBER", "big_decimal");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("VARCHAR2", "string");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("BLOB", "blob");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("CLOB", "clob");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("NCHAR", "char");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("NCLOB", "clob");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("NVARCHAR2", "string");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("RAW", "binary");
		// PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("ROWID", "1111");
		// PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("UROWID", "1111");
		// PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("BFILE", "-13");
		// PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("MLSLABEL", "1111");	
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("LONG RAW", "binary");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("TIMESTAMP", "timestamp");
		PREFERRED_HIBERNATETYPE_FOR_ORACLE.put("XMLTYPE", "clob");

	}

	public static String translateOracleTypeToHibernate(String oracleType) {

		String result = (String) PREFERRED_HIBERNATETYPE_FOR_ORACLE
				.get(oracleType);

		if (result == null) {
			return null;
		} else {
			return result;
		}
	}
}

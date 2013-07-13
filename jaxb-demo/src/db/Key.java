package db;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Key {
	private String columnName;

	private short keySeq;

	private String pkName;

	public Key() {
	}

	public Key(String columnName, short keySeq, String pkName) {
		this.columnName = columnName;
		this.keySeq = keySeq;
		this.pkName = pkName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public short getKeySeq() {
		return keySeq;
	}

	public void setKeySeq(short keySeq) {
		this.keySeq = keySeq;
	}

	public String getPkName() {
		return pkName;
	}

	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this).appendSuper(super
				.toString());
		builder.append("columnName", columnName).append("keySeq", keySeq)
				.append("pkName", pkName);
		return builder.toString();
	}

}

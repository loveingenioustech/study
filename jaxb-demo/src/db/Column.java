package db;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Column {
	private String name;

	private String type;

	private int size;

	private int decimalDigits;

	private boolean nullAble;

	public Column() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getDecimalDigits() {
		return decimalDigits;
	}

	public void setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

	public boolean isNullAble() {
		return nullAble;
	}

	public void setNullAble(boolean nullAble) {
		this.nullAble = nullAble;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this).appendSuper(super
				.toString());
		builder.append("name", name).append("type", type).append("size", size)
				.append("decimalDigits", decimalDigits)
				.append("nullAble", nullAble);
		return builder.toString();
	}

}

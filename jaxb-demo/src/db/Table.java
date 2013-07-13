package db;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Table {
	private String name;

	private List<Key> keies;

	private List<Column> columns;

	public Table() {
	}

	public Table(String name, List<Column> columns) {
		this.name = name;
		this.columns = columns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public List<Key> getKeies() {
		return keies;
	}

	public void setKeies(List<Key> keies) {
		this.keies = keies;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this).appendSuper(super
				.toString());
		builder.append("name", name).append("keies", keies)
				.append("columns", columns);
		return builder.toString();
	}

}

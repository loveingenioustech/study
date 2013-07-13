package hbm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "comment" })
@XmlRootElement(name = "column")
public class ColumnElement {

	protected String comment;
	@XmlAttribute(name = "name", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	@XmlAttribute(name = "length")
	@XmlSchemaType(name = "anySimpleType")
	protected String length;

	@XmlAttribute(name = "precision")
	@XmlSchemaType(name = "anySimpleType")
	protected String precision;

	@XmlAttribute(name = "scale")
	@XmlSchemaType(name = "anySimpleType")
	protected String scale;

	@XmlAttribute(name = "not-null")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String notNull;

	@XmlAttribute(name = "unique")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String unique;

	@XmlAttribute(name = "unique-key")
	@XmlSchemaType(name = "anySimpleType")
	protected String uniqueKey;

	@XmlAttribute(name = "sql-type")
	@XmlSchemaType(name = "anySimpleType")
	protected String sqlType;

	@XmlAttribute(name = "index")
	@XmlSchemaType(name = "anySimpleType")
	protected String index;

	@XmlAttribute(name = "check")
	@XmlSchemaType(name = "anySimpleType")
	protected String check;

	@XmlAttribute(name = "default")
	@XmlSchemaType(name = "anySimpleType")
	protected String _default;

	@XmlAttribute(name = "read")
	@XmlSchemaType(name = "anySimpleType")
	protected String read;

	@XmlAttribute(name = "write")
	@XmlSchemaType(name = "anySimpleType")
	protected String write;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getNotNull() {
		return notNull;
	}

	public void setNotNull(String notNull) {
		this.notNull = notNull;
	}

	public String getUnique() {
		return unique;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public String getSqlType() {
		return sqlType;
	}

	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getDefault() {
		return _default;
	}

	public void setDefault(String _default) {
		this._default = _default;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

}

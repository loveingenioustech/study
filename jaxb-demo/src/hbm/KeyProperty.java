package hbm;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import kepler.hibernate3.ColumnElement;
import kepler.hibernate3.TypeElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "columnElement", "typeElement" })
@XmlRootElement(name = "key-property")
public class KeyProperty {
	@XmlElement(name = "column-element")
	protected List<ColumnElement> columnElement;

	@XmlElement(name = "type-element")
	protected TypeElement typeElement;

	@XmlAttribute(name = "name", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	@XmlAttribute(name = "access")
	@XmlSchemaType(name = "anySimpleType")
	protected String access;

	@XmlAttribute(name = "type")
	@XmlSchemaType(name = "anySimpleType")
	protected String type;

	@XmlAttribute(name = "column")
	@XmlSchemaType(name = "anySimpleType")
	protected String column;

	@XmlAttribute(name = "length")
	@XmlSchemaType(name = "anySimpleType")
	protected String length;

	@XmlAttribute(name = "node")
	@XmlSchemaType(name = "anySimpleType")
	protected String node;

	public List<ColumnElement> getColumnElement() {
		if (columnElement == null) {
			columnElement = new ArrayList<ColumnElement>();
		}
		return this.columnElement;
	}

	public TypeElement getTypeElement() {
		return typeElement;
	}

	public void setTypeElement(TypeElement typeElement) {
		this.typeElement = typeElement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public void setColumnElement(List<ColumnElement> columnElement) {
		this.columnElement = columnElement;
	}

}

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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "columnElement", "typeElement", })
@XmlRootElement(name = "id")
public class Id {
	@XmlElement(name = "column-element")
	protected List<ColumnElement> columnElement;

	@XmlElement(name = "type-element")
	protected TypeElement typeElement;

	@XmlAttribute(name = "name")
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	@XmlAttribute(name = "node")
	@XmlSchemaType(name = "anySimpleType")
	protected String node;

	@XmlAttribute(name = "access")
	@XmlSchemaType(name = "anySimpleType")
	protected String access;

	@XmlAttribute(name = "column")
	@XmlSchemaType(name = "anySimpleType")
	protected String column;

	@XmlAttribute(name = "type")
	@XmlSchemaType(name = "anySimpleType")
	protected String type;

	@XmlAttribute(name = "length")
	@XmlSchemaType(name = "anySimpleType")
	protected String length;

	@XmlAttribute(name = "unsaved-value")
	@XmlSchemaType(name = "anySimpleType")
	protected String unsavedValue;

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

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getUnsavedValue() {
		return unsavedValue;
	}

	public void setUnsavedValue(String unsavedValue) {
		this.unsavedValue = unsavedValue;
	}

	public void setColumnElement(List<ColumnElement> columnElement) {
		this.columnElement = columnElement;
	}

}

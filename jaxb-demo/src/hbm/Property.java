package hbm;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "columnElementOrFormulaElement",
		"typeElement" })
@XmlRootElement(name = "property")
public class Property {

	@XmlElements({
			@XmlElement(name = "column", type = ColumnElement.class),
			@XmlElement(name = "formula", type = String.class) })
	protected List<Object> columnElementOrFormulaElement;

	@XmlElement(name = "type-element")
	protected TypeElement typeElement;

	@XmlAttribute(name = "name", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	@XmlAttribute(name = "type")
	@XmlSchemaType(name = "anySimpleType")
	protected String type;

	public List<Object> getColumnElementOrFormulaElement() {
		if (columnElementOrFormulaElement == null) {
			columnElementOrFormulaElement = new ArrayList<Object>();
		}
		return this.columnElementOrFormulaElement;
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

	public void setColumnElementOrFormulaElement(
			List<Object> columnElementOrFormulaElement) {
		this.columnElementOrFormulaElement = columnElementOrFormulaElement;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

package hbm;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "propertyOrManyToOneOrOneToOne" })
@XmlRootElement(name = "component")
public class Component {
	@XmlElements({ @XmlElement(name = "property", type = Property.class),
			@XmlElement(name = "component", type = Component.class), })
	protected java.util.List<Object> propertyOrManyToOneOrOneToOne;

	@XmlAttribute(name = "class")
	@XmlSchemaType(name = "anySimpleType")
	protected String clazz;

	@XmlAttribute(name = "name", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	public java.util.List<Object> getPropertyOrManyToOneOrOneToOne() {
		if (propertyOrManyToOneOrOneToOne == null) {
			propertyOrManyToOneOrOneToOne = new ArrayList<Object>();
		}
		return this.propertyOrManyToOneOrOneToOne;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPropertyOrManyToOneOrOneToOne(
			java.util.List<Object> propertyOrManyToOneOrOneToOne) {
		this.propertyOrManyToOneOrOneToOne = propertyOrManyToOneOrOneToOne;
	}

}

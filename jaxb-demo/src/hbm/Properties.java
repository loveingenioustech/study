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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "propertyOrManyToOneOrComponent" })
@XmlRootElement(name = "properties")
public class Properties {
	@XmlElements({ @XmlElement(name = "component", type = Component.class),
			@XmlElement(name = "property", type = Property.class) })
	protected List<Object> propertyOrManyToOneOrComponent;

	@XmlAttribute(name = "name", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	@XmlAttribute(name = "unique")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String unique;

	public List<Object> getPropertyOrManyToOneOrComponent() {
		if (propertyOrManyToOneOrComponent == null) {
			propertyOrManyToOneOrComponent = new ArrayList<Object>();
		}
		return this.propertyOrManyToOneOrComponent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnique() {
		return unique;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}

	public void setPropertyOrManyToOneOrComponent(
			List<Object> propertyOrManyToOneOrComponent) {
		this.propertyOrManyToOneOrComponent = propertyOrManyToOneOrComponent;
	}

}

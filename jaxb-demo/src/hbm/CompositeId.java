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
@XmlType(name = "", propOrder = { "keyPropertyOrKeyManyToOne", })
@XmlRootElement(name = "composite-id")
public class CompositeId {
	@XmlElements({ @XmlElement(name = "key-property", type = KeyProperty.class) })
	protected List<Object> keyPropertyOrKeyManyToOne;

	@XmlAttribute(name = "class")
	@XmlSchemaType(name = "anySimpleType")
	protected String clazz;

	@XmlAttribute(name = "mapped")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String mapped;

	@XmlAttribute(name = "name")
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	public List<Object> getKeyPropertyOrKeyManyToOne() {
		if (keyPropertyOrKeyManyToOne == null) {
			keyPropertyOrKeyManyToOne = new ArrayList<Object>();
		}
		return this.keyPropertyOrKeyManyToOne;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getMapped() {
		return mapped;
	}

	public void setMapped(String mapped) {
		this.mapped = mapped;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKeyPropertyOrKeyManyToOne(
			List<Object> keyPropertyOrKeyManyToOne) {
		this.keyPropertyOrKeyManyToOne = keyPropertyOrKeyManyToOne;
	}

}

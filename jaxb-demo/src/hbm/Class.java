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
@XmlType(name = "", propOrder = { "subselectElement", "comment", "id",
		"compositeId", "propertyOrManyToOneOrOneToOne", "queryOrSqlQuery" })
@XmlRootElement(name = "class")
public class Class {

	@XmlElement(name = "subselect-element")
	protected String subselectElement;

	protected String comment;

	protected Id id;

	@XmlElement(name = "composite-id")
	protected CompositeId compositeId;

	@XmlElements({ @XmlElement(name = "sql-query", type = SqlQuery.class),
			@XmlElement(name = "query", type = Query.class) })
	protected java.util.List<Object> queryOrSqlQuery;

	@XmlAttribute(name = "name")
	@XmlSchemaType(name = "anySimpleType")
	protected String name;

	@XmlAttribute(name = "table")
	@XmlSchemaType(name = "anySimpleType")
	protected String table;

	@XmlElements({ @XmlElement(name = "property", type = Property.class),
			@XmlElement(name = "component", type = Component.class),
			@XmlElement(name = "properties", type = Properties.class), })
	protected java.util.List<Object> propertyOrManyToOneOrOneToOne;

	/**
	 * Gets the value of the subselectElement property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubselectElement() {
		return subselectElement;
	}

	/**
	 * Sets the value of the subselectElement property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubselectElement(String value) {
		this.subselectElement = value;
	}

	/**
	 * Gets the value of the comment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the value of the comment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setComment(String value) {
		this.comment = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link Id }
	 * 
	 */
	public Id getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link Id }
	 * 
	 */
	public void setId(Id value) {
		this.id = value;
	}

	/**
	 * Gets the value of the compositeId property.
	 * 
	 * @return possible object is {@link CompositeId }
	 * 
	 */
	public CompositeId getCompositeId() {
		return compositeId;
	}

	/**
	 * Sets the value of the compositeId property.
	 * 
	 * @param value
	 *            allowed object is {@link CompositeId }
	 * 
	 */
	public void setCompositeId(CompositeId value) {
		this.compositeId = value;
	}

	/**
	 * Gets the value of the queryOrSqlQuery property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the queryOrSqlQuery property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getQueryOrSqlQuery().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link SqlQuery }
	 * {@link Query }
	 * 
	 * 
	 */
	public java.util.List<Object> getQueryOrSqlQuery() {
		if (queryOrSqlQuery == null) {
			queryOrSqlQuery = new ArrayList<Object>();
		}
		return this.queryOrSqlQuery;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the table property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTable() {
		return table;
	}

	/**
	 * Sets the value of the table property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTable(String value) {
		this.table = value;
	}

	public void setQueryOrSqlQuery(java.util.List<Object> queryOrSqlQuery) {
		this.queryOrSqlQuery = queryOrSqlQuery;
	}

	public void setPropertyOrManyToOneOrOneToOne(
			java.util.List<Object> propertyOrManyToOneOrOneToOne) {
		this.propertyOrManyToOneOrOneToOne = propertyOrManyToOneOrOneToOne;
	}

	public java.util.List<Object> getPropertyOrManyToOneOrOneToOne() {
		if (propertyOrManyToOneOrOneToOne == null) {
			propertyOrManyToOneOrOneToOne = new ArrayList<Object>();
		}
		return this.propertyOrManyToOneOrOneToOne;
	}

}

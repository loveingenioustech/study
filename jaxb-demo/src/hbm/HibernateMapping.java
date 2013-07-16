package hbm;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "clazzOrSubclassOrJoinedSubclass",
		"queryOrSqlQuery" })
@XmlRootElement(name = "hibernate-mapping", namespace = "")
public class HibernateMapping {

	@XmlElements({ @XmlElement(name = "class", type = Class.class), })
	protected List<Object> clazzOrSubclassOrJoinedSubclass;

	@XmlElements({ @XmlElement(name = "query", type = Query.class),
			@XmlElement(name = "sql-query", type = SqlQuery.class) })
	protected List<Object> queryOrSqlQuery;

	public HibernateMapping() {
	}

	public List<Object> getClazzOrSubclassOrJoinedSubclass() {
		if (clazzOrSubclassOrJoinedSubclass == null) {
			clazzOrSubclassOrJoinedSubclass = new ArrayList<Object>();
		}
		return this.clazzOrSubclassOrJoinedSubclass;
	}

	public void setClazzOrSubclassOrJoinedSubclass(
			List<Object> clazzOrSubclassOrJoinedSubclass) {
		this.clazzOrSubclassOrJoinedSubclass = clazzOrSubclassOrJoinedSubclass;
	}

	public List<Object> getQueryOrSqlQuery() {
		if (queryOrSqlQuery == null) {
			queryOrSqlQuery = new ArrayList<Object>();
		}
		return this.queryOrSqlQuery;
	}

	public void setQueryOrSqlQuery(List<Object> queryOrSqlQuery) {
		this.queryOrSqlQuery = queryOrSqlQuery;
	}

}

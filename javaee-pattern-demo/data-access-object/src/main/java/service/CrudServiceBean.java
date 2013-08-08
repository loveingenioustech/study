package service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(CrudService.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CrudServiceBean implements CrudService {
	@PersistenceContext
	EntityManager em;

	@Override
	public <T> T create(T t) {
		this.em.persist(t);
		this.em.flush();
		this.em.refresh(t);
		return t;
	}

	@Override
	public <T> T find(Object id, Class<T> type) {
		return (T) this.em.find(type, id);
	}

	@Override
	public <T> T update(T t) {
		return (T) this.em.merge(t);
	}

	/**
	 * Doesn't work
	 * 
	 * Caused by: org.hibernate.TypeMismatchException: Provided id of the wrong
	 * type for class model.Book. Expected: class java.lang.String, got class
	 * model.Book
	 * 
	 */
	@Override
	public void delete(Object t) {
		Object ref = this.em.getReference(t.getClass(), t);
		this.em.remove(ref);
	}
	
	@Override
	public void delete(Object t, Object id){
		Object ref = this.em.getReference(t.getClass(), id);
		this.em.remove(ref);		
	}

	@Override
	public List findByNamedQuery(String queryName) {
		return this.em.createNamedQuery(queryName).getResultList();
	}

	@Override
	public List findByNamedQuery(String queryName, int resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit)
				.getResultList();
	}

	@Override
	public List findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters) {
		return findByNamedQuery(namedQueryName, parameters, 0);
	}

	@Override
	public List findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQueryName);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	@Override
	public List findByNativeQuery(String sql, Class type) {
		return this.em.createNativeQuery(sql, type).getResultList();
	}

}

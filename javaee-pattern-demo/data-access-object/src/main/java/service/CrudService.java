package service;

import java.util.List;
import java.util.Map;

public interface CrudService {
	<T> T create(T t);

	<T> T find(Object id, Class<T> type);

	<T> T update(T t);

	void delete(Object t);

	void delete(Object t, Object id);

	List findByNamedQuery(String queryName);

	List findByNamedQuery(String queryName, int resultLimit);

	List findByNamedQuery(String namedQueryName, Map<String, Object> parameters);

	List findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit);

	List findByNativeQuery(String sql, Class type);
}

package paginator;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class CustomerQueryPageOrEverythingBean
 */
@Stateless
public class CustomerQueryPageOrEverythingBean {

	@PersistenceContext
	EntityManager em;

	private static int MAX_PAGE_SIZE = 1000;

	/**
	 * Default constructor.
	 */
	public CustomerQueryPageOrEverythingBean() {
	}

	public List<Customer> getAllCustomers(int maxResults) {
		if (maxResults == -1 || maxResults > MAX_PAGE_SIZE)
			maxResults = MAX_PAGE_SIZE;
		else
			maxResults += 1;
		
		Query query = this.em.createNamedQuery("Customer.findAll");
		query.setMaxResults(maxResults);
		return query.getResultList();
	}

}

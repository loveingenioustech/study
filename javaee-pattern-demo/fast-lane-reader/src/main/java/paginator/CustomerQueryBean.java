package paginator;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class CustomerQueryBean
 */
@Stateful
public class CustomerQueryBean implements Iterator<List<Customer>> {

	@PersistenceContext
	EntityManager em;

	private int index = 0;
	private int pageSize = 10;
	private boolean next = true;

	/**
	 * Default constructor.
	 */
	public CustomerQueryBean() {
		// TODO Auto-generated constructor stub
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @see Iterator#hasNext()
	 */
	public boolean hasNext() {
		return this.next;
	}

	/**
	 * @see Iterator#next()
	 */
	public List<Customer> next() {
		List<Customer> retVal = null;
		Query query = this.em.createNamedQuery("Customer.findAll");
		query.setFirstResult(getFirst());
		query.setMaxResults(pageSize);
		retVal = query.getResultList();
		if (retVal.size() == 0) {
			this.next = false;
		}
		index++;
		return retVal;
	}

	private int getFirst() {
		return index * pageSize;
	}

	/**
	 * @see Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException("Operation remove …");
	}

	@Remove
	public void close() {
		this.em.clear();
		this.em.close();
	}

}

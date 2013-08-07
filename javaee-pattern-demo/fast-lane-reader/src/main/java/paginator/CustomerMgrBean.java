package paginator;

import javax.persistence.EntityManager;

public class CustomerMgrBean {

	public EntityManager em;

	public void create(Customer customer) {
		this.em.persist(customer);
	}

	public void deleteAll() {
		this.em.createNamedQuery("Customer.deleteAll").executeUpdate();
	}

}

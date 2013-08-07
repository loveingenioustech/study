package paginator;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerQueryBeanTest {

	private CustomerQueryBean query;
	private CustomerMgrBean mgr;
	private EntityManager em;
	private EntityTransaction et;

	@Before
	public void setUp() throws Exception {
		this.em = Persistence.createEntityManagerFactory("fast-lane-reader")
				.createEntityManager();
		this.et = this.em.getTransaction();

		this.query = new CustomerQueryBean();
		this.query.em = this.em;
		this.mgr = new CustomerMgrBean();
		this.mgr.em = this.em;
		this.et.begin();
		for (int i = 0; i < 100; i++) {
			Customer customer = new Customer();
			customer.setFirstName("Robin " + i);
			customer.setLastName("Long");
			customer.setBornDate(new Date());

			this.mgr.create(customer);
		}
		this.et.commit();

	}

	@After
	public void tearDown() throws Exception {
		this.et.begin();
		this.mgr.deleteAll();
		this.et.commit();
	}

	@Test
	public void testNext() {
		while (query.hasNext()) {
			List<Customer> customers = query.next();
			System.out.println("Size: " + customers.size());
			for (Customer customer : customers) {
				System.out.println("Customer: " + customer);
			}
		}

	}

}

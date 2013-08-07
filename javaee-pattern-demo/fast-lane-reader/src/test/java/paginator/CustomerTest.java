package paginator;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("fast-lane-reader");
		EntityManager em = emf.createEntityManager();
		CustomerMgrBean customerMgrBean = new CustomerMgrBean();
		customerMgrBean.em = em;

		// create and persist an Customer

		Customer customer = new Customer();
		customer.setFirstName("Robin");
		customer.setLastName("Long");
		customer.setBornDate(new Date());

		em.getTransaction().begin();
		customerMgrBean.create(customer);
		em.getTransaction().commit();
		System.out.println("Persisted " + customer);
	}

}

package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Book;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CrudServiceBeanTest {

	private EntityManager em;
	private EntityTransaction et;
	private CrudServiceBean crudServiceBean;

	@Before
	public void setUp() throws Exception {
		this.em = Persistence.createEntityManagerFactory("data-access-object")
				.createEntityManager();
		this.et = this.em.getTransaction();
		this.crudServiceBean = new CrudServiceBean();
		this.crudServiceBean.em = this.em;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Book book = new Book("1", "Productive Java EE", new Date());
		this.et.begin();
		int initialSize = this.crudServiceBean.findByNamedQuery(Book.ALL)
				.size();
		// create
		Book created = this.crudServiceBean.create(book);
		assertNotNull(created);
		assertEquals(book.getIsbn(), created.getIsbn());
		assertEquals(book.getName(), created.getName());
		Book found = this.crudServiceBean.find(created.getIsbn(), Book.class);
		assertNotNull(found);
		assertEquals(found.getIsbn(), created.getIsbn());

		// query
		int size = this.crudServiceBean.findByNamedQuery(Book.ALL).size();
		assertEquals(initialSize + 1, size);
		String newName = book.getName() + " Second Edition";
		book.setName(newName);

		// update
		Book updated = (Book) this.crudServiceBean.update(book);
		assertNotNull(updated);
		Book foundUpdated = this.crudServiceBean.find(created.getIsbn(),
				Book.class);
		assertNotNull(foundUpdated);
		assertEquals(updated.getName(), foundUpdated.getName());
		
		// delete
//		this.crudServiceBean.delete(foundUpdated);
		this.crudServiceBean.delete(foundUpdated, foundUpdated.getIsbn());
		Book shouldntExist = this.crudServiceBean.find(created.getIsbn(),
				Book.class);
		assertNull(shouldntExist);
		int zero = this.crudServiceBean.findByNamedQuery(Book.ALL).size();
		assertEquals(0, zero);
		this.et.rollback();
	}

}

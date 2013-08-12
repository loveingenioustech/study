package demo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.dto.Event;
import demo.util.HibernateUtil;

public class EventDaoImpl implements EventDao {

	public void saveEvent(Event event) {
		System.out.println("Enter DAO Impl");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(event);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	@Override
	public List<Event> getEventList() {
		return this.getEventList(0, 0);
	}

	@Override
	public List<Event> getEventList(int pageNumber, int pageSize) {
		System.out.println("Enter DAO Impl");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		List<Event> events = null;
		try {
			Query query = session.createQuery("from Event");

			// Page pagination
			if (pageNumber != 0 && pageSize != 0) {
				query.setFirstResult((pageNumber - 1) * pageSize);
				query.setMaxResults(pageSize);
			}

			events = query.list();
		} finally {
			session.close();
		}

		return events;
	}
}

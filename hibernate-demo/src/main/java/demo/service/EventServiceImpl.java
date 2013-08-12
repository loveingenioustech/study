package demo.service;

import java.util.List;

import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import demo.dao.EventDao;
import demo.dao.EventDaoImpl;
import demo.dto.Event;

public class EventServiceImpl implements EventService {

	private EventDao eventDao = new EventDaoImpl();

	public void saveEvent(Event event) {
		System.out.println("Enter saveEvent Service");
		EventDao dao = new EventDaoImpl();
		try {
			dao.saveEvent(event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End saveEvent Service");
	}

	@Override
	public List<Event> getEventList() {
		return eventDao.getEventList();
	}

	@Override
	public List<Event> getEventList(int pageNumber, int pageSize) {
		return eventDao.getEventList(pageNumber, pageSize);
	}

}

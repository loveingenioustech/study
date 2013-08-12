package demo.dao;

import java.util.List;

import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;

import demo.dto.Event;

/**
 * @author Robin
 * 
 */
public interface EventDao {
	public void saveEvent(Event event);

	public List<Event> getEventList();

	public List<Event> getEventList(int pageNumber, int pageSize);

}

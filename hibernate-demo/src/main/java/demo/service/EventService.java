package demo.service;

import java.util.List;

import demo.dto.Event;

/**
 * @author Robin
 * 
 */
public interface EventService {

	public void saveEvent(Event event);

	public List<Event> getEventList();

	public List<Event> getEventList(final int pageNumber, final int pageSize);

}

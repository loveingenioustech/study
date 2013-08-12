package demo.control;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.dto.Event;
import demo.service.EventService;
import demo.service.EventServiceImpl;

/**
 * Servlet implementation class ListEventServlet
 */
@WebServlet("/CreateEventServlet")
public class CreateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EventService eventService = new EventServiceImpl();

		BigDecimal eventId = BigDecimal.valueOf(Integer.valueOf(request
				.getParameter("eventId")));
		String title = request.getParameter("eventTitle");
		String title_pound = request.getParameter("titlePound");
		Date start_date = new Date();
		
		if (eventId != null && title != null) {
			Event event = new Event(eventId, title, title_pound, start_date);

			eventService.saveEvent(event);
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListEventServlet");
		dispatcher.forward(request, response);
	}

}

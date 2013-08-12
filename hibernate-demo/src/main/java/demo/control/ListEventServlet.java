package demo.control;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/ListEventServlet")
public class ListEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListEventServlet() {
		super();
	}

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

		List<Event> events = eventService.getEventList(1, 10);

		request.setAttribute("events", events);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("pages/ListEvent.jsp");
		dispatcher.forward(request, response);
	}

}

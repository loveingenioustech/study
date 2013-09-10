package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogonFormServlet
 */
@WebServlet("/LogonFormServlet")
public class LogonFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogonFormServlet() {
		super();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		if (session == null) {
			out.println("Check Code handling error!!!is no");
			return;
		}

		String savedCode = (String) session.getAttribute("check_code");
		if (savedCode == null) {
			out.println("Check Code handling error!!!");
			return;
		}

		String checkCode = (String) request.getParameter("check_code");
		if (!savedCode.equals(checkCode)) {
			out.println("Invalid Check Code");
			return;
		}

		session.removeAttribute("check_code");
		out.println("Check Code passed!");

	}

}

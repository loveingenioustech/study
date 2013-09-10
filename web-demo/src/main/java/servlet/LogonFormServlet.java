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
		// response.setContentType("text/html;charset=UTF-8");
		// PrintWriter out = response.getWriter();

		String errorMsg = "";

		HttpSession session = request.getSession();

		if (session == null) {
			errorMsg = "Check Code handling error!!!is no";
		} else {
			String savedCode = (String) session.getAttribute("check_code");
			if (savedCode == null) {
				errorMsg = "Check Code handling error!!!";
			}

			String checkCode = (String) request.getParameter("check_code");
			if (!savedCode.equals(checkCode)) {
				errorMsg = "Invalid Check Code";
			}

			// Check Code passed, validate username and password
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");

			// Dummy validation
			if (username.equals("robin") && pwd.equals("robin")) {
				session.setAttribute("result", "ok");
			} else {
				session.setAttribute("result", "wrong");
			}

			// Remove check code
			session.removeAttribute("check_code");
		}

		response.sendRedirect("pages/login.jsp");
	}

}

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
    	request.setCharacterEncoding("UTF-8");

//		response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/xml; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = response.getWriter();

		String loginMsg = "";

		HttpSession session = request.getSession();

		out.println("<response>");
		
		if (session == null) {
			loginMsg = "Check Code handling error!!!is no";
		} else {
			String savedCode = (String) session.getAttribute("check_code");
			if (savedCode == null) {
				loginMsg = "Check Code handling error!!!";
			}

			String checkCode = (String) request.getParameter("check_code");
			if (!savedCode.equals(checkCode)) {
				loginMsg = "Invalid Check Code";
			}

			// Check Code passed, validate username and password
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");

			// Dummy validation
			if (username.equals("robin") && pwd.equals("robin")) {
				loginMsg = "OK";
//				session.setAttribute("result", "ok");
			} else {
				loginMsg = "Wrong User Name or Password!";
//				session.setAttribute("result", "wrong");
			}
			
			out.println("<res>" + loginMsg + "</res>");
			out.println("</response>");
			out.close();
			
			// Remove check code
			session.removeAttribute("check_code");
		}

//		response.sendRedirect("pages/login.jsp");
	}

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBUtil;

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

		// response.setContentType("text/html;charset=UTF-8");
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

			// DB Validation
			DBUtil dbUtil = new DBUtil();

			String querySql = "select * from wd_user where username='"
					+ username + "' and password='" + pwd + "'";

			System.out.println("querySql: " + querySql);

			ResultSet rs = dbUtil.executeQuery(querySql);

			try {
				if (rs.next()) {
					loginMsg = "OK";
				} else {
					loginMsg = "Wrong User Name or Password!";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				loginMsg = "DB Error!";
			}

			out.println("<res>" + loginMsg + "</res>");
			out.println("</response>");
			out.close();

			// Remove check code
			session.removeAttribute("check_code");
		}

		// response.sendRedirect("pages/login.jsp");
	}

}

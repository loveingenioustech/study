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

import util.DBUtil;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");

		PrintWriter out = response.getWriter();

		out.println("<response>");

		// Database operation
		DBUtil db = new DBUtil();
		ResultSet rs;
		int insRes = 0;
		String strSql = null;

		// Check whether username is already exists
		strSql = "select * from wd_user where username='" + username + "'";
		rs = db.executeQuery(strSql);

		boolean bnoRepeat = false;
		try {
			if (!rs.next()) {
				bnoRepeat = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// User name is ok, insert into database
		if (bnoRepeat) {
			strSql = "Insert Into wd_user values('" + username + "','" + pwd
					+ "')";
			insRes = db.executeUpdate(strSql);
		}
		if (!bnoRepeat) {
			out.println("<res>"
					+ "Signup failed! User Name already exist, please input another name"
					+ "</res>");
		} else if (insRes > 0) {
			out.println("<res>" + "Signup successfully!" + "</res>");
		} else {
			out.println("<res>" + "Signup failed!" + "</res>");
		}

		out.println("</response>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

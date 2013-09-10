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
import domain.Product;

/**
 * Servlet implementation class TipServlet
 */
@WebServlet("/TipServlet")
public class TipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TipServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer key = Integer.valueOf(request.getParameter("key"));

		Product product = null;

		try {
			product = getProduct(key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Sent back data
		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println("<response>");
		out.println("<content>" + product.getContents() + "</content>");
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

	private Product getProduct(Integer key) throws SQLException {
		// Get detail info from DB
		DBUtil db = new DBUtil();

		ResultSet rs;
		String strSql = null;
		String rplContent = null;

		strSql = "select * from wd_product where id = " + key;

		rs = db.executeQuery(strSql);

		Product product = new Product();

		if (rs.next()) {
			product.setName(rs.getString("name"));
			rplContent = rs.getString("contents");
			rplContent = rplContent.replaceAll("\n", "<br>");
			product.setContents(rplContent);
		}
		return product;
	}

}

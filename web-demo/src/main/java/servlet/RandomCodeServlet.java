package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomCodeServlet
 */
@WebServlet("/RandomCodeServlet")
public class RandomCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RandomCodeServlet() {
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
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		Random r = new Random();
		int width = 60;
		int height = 20;
		BufferedImage pic = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics gc = pic.getGraphics();
		gc.setColor(getRandColor(200, 500));
		gc.fillRect(0, 0, width, height);
		gc.setFont(new Font("Times New Romand", Font.PLAIN, 18));
		gc.setColor(getRandColor(160, 200));
		for (int i = 0; i < 200; i++) {
			int x1 = r.nextInt(width);
			int y1 = r.nextInt(height);
			int x2 = r.nextInt(15);
			int y2 = r.nextInt(15);
			gc.drawLine(x1, y1, x2 + x1, y2 + y1);
		}
		gc.setColor(getRandColor(120, 240));
		for (int i = 0; i < 100; i++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			gc.drawOval(x, y, 0, 0);
		}
		String Rs = "";
		String rn = "";
		for (int i = 0; i < 4; i++) {
			rn = String.valueOf(r.nextInt(10));
			Rs += rn;
			gc.setColor(new Color(20 + r.nextInt(110), 20 + r.nextInt(110),
					20 + r.nextInt(110)));
			gc.drawString(rn, 13 * i + 6, 16);

		}

		gc.dispose();
		HttpSession session = request.getSession();
		session.setAttribute("random", Rs);
		ImageIO.write(pic, "JPEG", response.getOutputStream());

	}

	public Color getRandColor(int fc, int bc) {
		Random r = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int red = fc + r.nextInt(bc - fc);
		int green = fc + r.nextInt(bc - fc);
		int blue = fc + r.nextInt(bc - fc);

		return new Color(red, green, blue);
	}

}

package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);
		  ServletOutputStream sos=response.getOutputStream();
		    BufferedImage image=new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
		      Graphics g=image.getGraphics();
		        g.fillRect(0,0,0,0);
		        g.setColor(Color.BLUE);
		        g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));
		        String value=getAccessCont(request);
		        int len=value.length();
		         if(len>7){
		        	 value="9999999";
		         }else{
		        	 String tmp="";
		        	  for(int i=0;i<7-len;i++){
		        		  tmp=tmp+"0";
		        	  }
		        	  value=tmp+value;
		         }
		         g.drawString(value,0,18);
		         g.dispose();
		         ImageIO.write(image,"JPEG",sos);
		         sos.close();	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	
	private String getAccessCont(HttpServletRequest request){		
		  String pagekey=request.getHeader("referer");
		  if(pagekey==null){
			  return "0";
		  }
		  Properties settings=new Properties();
		  String contFilePath=this.getServletContext().getRealPath("/count.txt");
		  try{
			  settings.load(new FileInputStream(contFilePath));
			  
		  }catch(Exception e){
			  
		  }
		String count="0";
		try{
			count=settings.getProperty(pagekey);
			if (count==null){
				 count="0";
				 
			}
			int c=Integer.parseInt(count)+1;
			 count=new Integer(c).toString();
			 settings.put(pagekey,count);
			 settings.store(new FileOutputStream(contFilePath),"the page is accessed:");
			 
		}catch(Exception e){
			
		}
		
		return count;
		
	}
}

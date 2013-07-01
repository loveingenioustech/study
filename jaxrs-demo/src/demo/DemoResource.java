package demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/demo")
public class DemoResource {

	@GET
	@Produces("text/plain")
	public String getClichedMessage() {
		return "Demo JAX-RS";
	}

//	@GET
//	@Produces("application/xml")
//	public String getXMLMessage() {
//		return "<?xml version=\"1.0\"?>" + "<demo> Demo JAX-RS" + "</demo>";
//	}
	
	// @GET
	// @Produces("text/xml")
	// public String getXMLMessage() {
	// return "<?xml version=\"1.0\"?>" + "<hello> Hello JAX-RS" + "</hello>";
	// }	

//	@GET
//	@Produces("text/html")
//	public String getHTMLMessage() {
//		return "<html> " + "<title>" + "Hello JAX-RS" + "</title>"
//				+ "<body><h1>" + "Hello JAX-RS" + "</body></h1>" + "</html>";
//	}
}

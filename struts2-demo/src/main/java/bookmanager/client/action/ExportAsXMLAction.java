package bookmanager.client.action;

import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import bookmanager.server.beans.Book;
import bookmanager.server.services.Persistence;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ExportAsXMLAction extends ActionSupport {
	List<Book> books = new ArrayList<Book>();
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public String execute() throws Exception {

		books = Persistence.getInstance().getAllBooks();

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		XMLEncoder xmlEncoder = new XMLEncoder(byteArrayOutputStream);
		xmlEncoder.writeObject(books);
		xmlEncoder.flush();
		xmlEncoder.close();
		byteArrayOutputStream.flush();

		String whatsup = byteArrayOutputStream.toString();
		byteArrayOutputStream.close();
		System.out.println("xml=" + whatsup);
		inputStream = new ByteArrayInputStream(whatsup.getBytes());

		return SUCCESS;
	}
}

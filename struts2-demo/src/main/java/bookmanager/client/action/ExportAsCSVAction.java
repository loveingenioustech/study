package bookmanager.client.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import bookmanager.server.beans.Book;
import bookmanager.server.services.Escaper;
import bookmanager.server.services.Persistence;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ExportAsCSVAction extends ActionSupport {
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
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer
				.append("book_id, catalog, title, author, copyright, binding\n");
		books = Persistence.getInstance().getAllBooks();
		for (Book book : books) {
			stringBuffer.append(book.getBook_id() + ",");
			stringBuffer.append(Escaper.escapeCSV(book.getCatalog()) + ",");
			stringBuffer.append(Escaper.escapeCSV(book.getTitle()) + ",");
			stringBuffer.append(Escaper.escapeCSV(book.getAuthor()) + ",");
			stringBuffer.append(book.getCopyright() + ",");
			stringBuffer.append(Escaper.escapeCSV(book.getBinding()) + "\n");
		}
		inputStream = new ByteArrayInputStream(stringBuffer.toString()
				.getBytes());
		return SUCCESS;
	}
}

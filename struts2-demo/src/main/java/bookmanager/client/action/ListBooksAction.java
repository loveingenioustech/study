package bookmanager.client.action;

import java.util.ArrayList;
import java.util.List;

import bookmanager.server.beans.Book;
import bookmanager.server.services.Persistence;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ListBooksAction extends ActionSupport {
	List<Book> books = new ArrayList<Book>();

	public String execute() throws Exception {
		books = Persistence.getInstance().getAllBooks();
		return SUCCESS;
	}

	public List<Book> getBooks() {
		return books;
	}
}

package bookmanager.client.action;

import bookmanager.server.beans.Book;
import bookmanager.server.services.Persistence;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddBookAction extends ActionSupport {
	String catalog;
	String title;
	String author;
	Integer copyright;
	String binding;

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getCopyright() {
		return copyright;
	}

	public void setCopyright(Integer copyright) {
		this.copyright = copyright;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String execute() throws Exception {
		String successFlag = SUCCESS;
		Book book = new Book();
		book.setTitle(title);
		book.setCatalog(catalog);
		book.setAuthor(author);
		book.setBinding(binding);
		book.setCopyright(copyright);
		try {
			Persistence.getInstance().addBook(book);
		} catch (Exception e) {
			e.printStackTrace();
			successFlag = ERROR;
		}
		return successFlag;
	}
}

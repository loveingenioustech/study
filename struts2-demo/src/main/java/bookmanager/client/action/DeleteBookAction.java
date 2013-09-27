package bookmanager.client.action;

import bookmanager.server.beans.Book;
import bookmanager.server.services.Persistence;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteBookAction extends ActionSupport {
	Long book_id;

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long bookId) {
		book_id = bookId;
	}

	public String execute() throws Exception {
		String successFlag = SUCCESS;
		Book book = new Book();
		book.setBook_id(book_id);
		try {
			Persistence.getInstance().deleteBook(book);
		} catch (Exception e) {
			e.printStackTrace();
			successFlag = ERROR;
		}
		return successFlag;
	}
}

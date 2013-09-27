package bookmanager.server.beans;

public class Book {

	Long book_id;
	String catalog;
	String title;
	String author;
	Integer copyright;
	String binding;

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long bookId) {
		book_id = bookId;
	}

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

	public String toString() {
		return "book_id=" + getBook_id() + "; catalog=" + getCatalog()
				+ "; title=" + getTitle() + " author=" + getAuthor()
				+ "; copyright=" + getCopyright() + "; binding=" + getBinding();
	}

}

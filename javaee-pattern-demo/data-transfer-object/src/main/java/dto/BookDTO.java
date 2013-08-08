package dto;

public class BookDTO {
	private int numberOfPages;
	
	private String name;
	
	public BookDTO(int numberOfPages, String name) {
		this.numberOfPages = numberOfPages;
		this.name = name;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

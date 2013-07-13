package eclipse.demo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "catalog", namespace = "http://www.example.org/catalog")
@XmlType(name = "", propOrder = { "publisher", "edition", "title", "author" })
public class Catalog {

	@XmlElement
	private String publisher;

	@XmlElement
	private String edition;

	@XmlElement
	private String title;

	@XmlElement
	private String author;
	
	@XmlAttribute
	public String journal;
	
	public Catalog() {
	}

	public Catalog(String journal, String publisher, String edition,
			String title, String author) {

		this.journal = journal;
		this.publisher = publisher;
		this.edition = edition;
		this.title = title;
		this.author = author;
	}

	private String getJournal() {
		return this.journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}

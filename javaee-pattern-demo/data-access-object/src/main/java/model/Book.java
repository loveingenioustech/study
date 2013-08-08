package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = Book.ALL, query = "Select b From Book b"),
		@NamedQuery(name = Book.BY_NAME, query = "Select b From Book b where b.name = :name") })
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String ALL = "...crud.domain.Book.ALL";
	public final static String BY_NAME = "...crud.domain.Book.BY_NAME";

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISBN", nullable = false, length = 50)
	private String isbn;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "PUBLISH_DATE", nullable = false)
	private Date publishDate;

	public Book() {
	}

	public Book(String isbn, String name, Date publishDate) {
		this.isbn = isbn;
		this.name = name;
		this.publishDate = publishDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}

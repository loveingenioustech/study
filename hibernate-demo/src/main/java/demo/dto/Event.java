package demo.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Robin Long
 */
public class Event implements Serializable {
	/**
	 * Version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private java.math.BigDecimal id = null;
	/**
	 * title
	 */
	private String title = null;
	/**
	 * title_pound
	 */
	private String titlePound = null;
	/**
	 * start_date
	 */
	private java.util.Date startDate = null;

	public Event() {
	}

	public Event(final java.math.BigDecimal id, final String title,
			final String title_pound, final java.util.Date start_date) {
		this.id = id;
		this.title = title;
		this.titlePound = title_pound;
		this.startDate = start_date;
	}

	/**
	 * @return the id
	 */
	public java.math.BigDecimal getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final java.math.BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	public String getTitlePound() {
		return titlePound;
	}

	public void setTitlePound(final String titlePound) {
		this.titlePound = titlePound;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(final java.util.Date startDate) {
		this.startDate = startDate;
	}

	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
				.append("id", this.id).append("title", this.title)
				.append("title_pound", this.titlePound)
				.append("start_date", this.startDate).toString();
	}
}

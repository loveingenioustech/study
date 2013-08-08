package dto;

import java.io.Serializable;

public class BuilderStyleImmutableDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int numberOfPages;

	private final String name;

	private String description;

	private BuilderStyleImmutableDTO(Builder builder) {
		this.numberOfPages = builder.numberOfPages;
		this.name = builder.name;
		this.description = builder.description;
	}

	public static class Builder {
		private final int numberOfPages;
		private final String name;
		private String description;

		public Builder(int numberOfPages, String name) {
			this.numberOfPages = numberOfPages;
			this.name = name;
		}

		public Builder description(String name) {
			if (name == null)
				throw new IllegalArgumentException("Description cannot be null");
			return this;
		}

		public BuilderStyleImmutableDTO build() {
			return new BuilderStyleImmutableDTO(this);
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public String getName() {
		return name;
	}

}

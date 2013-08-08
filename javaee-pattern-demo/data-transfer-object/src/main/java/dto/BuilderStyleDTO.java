package dto;

import java.io.Serializable;

public class BuilderStyleDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numberOfPages;

	private String name;

	private BuilderStyleDTO() {
	}

	public BuilderStyleDTO(int numberOfPages, String name) {
		this.numberOfPages = numberOfPages;
		this.name = name;
	}

	public static class Builder {
		private BuilderStyleDTO builderStyleDTO;

		Builder() {
			this.builderStyleDTO = new BuilderStyleDTO();
		}

		public Builder numberOfPages(int pages) {
			if (pages < 1)
				throw new IllegalArgumentException(
						"A book should have at least one page");
			this.builderStyleDTO.setNumberOfPages(pages);
			return this;
		}

		public Builder name(String name) {
			if (name == null)
				throw new IllegalArgumentException("A book should have a name");
			return this;
		}

		public BuilderStyleDTO build() {
			return this.builderStyleDTO;
		}
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

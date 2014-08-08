package builder;

import java.util.Date;

public class Pet {
	public static class Builder {
		private String petName;
		private String ownerName;
		private String address;
		private String telephone;
		private Date dateOfBirth;
		private String emailAddress;

		public Builder withPetName(final String petName) {
			this.petName = petName;
			return this;
		}

		public Builder withOwnerName(final String ownerName) {
			this.ownerName = ownerName;
			return this;
		}

		public Builder withAddress(final String address) {
			this.address = address;
			return this;
		}

		public Builder withTelephone(final String telephone) {
			this.telephone = telephone;
			return this;
		}

		public Builder withDateOfBirth(final Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder withEmailAddress(final String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}

		public Pet build() {
			if (petName == null || ownerName == null || address == null
					|| telephone == null) {
				throw new IllegalStateException("Cannot create Pet");
			}
			return new Pet(petName, ownerName, address, telephone, dateOfBirth,
					emailAddress);
		}

	}

	private final String petName;
	private final String ownerName;
	private final String address;
	private final String telephone;
	private final Date dateOfBirth; // optional
	private final String emailAddress; // optional

	private Pet(final String petName, final String ownerName,
			final String address, final String telephone,
			final Date dateOfBirth, final String emailAddress) {
		this.petName = petName;
		this.ownerName = ownerName;
		this.address = address;
		this.telephone = telephone;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
	}
}

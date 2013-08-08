package dto;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableBookDTO implements Externalizable {
	private int numberOfPages;

	private String name;

	/** Mandatory for Externalizable */
	public ExternalizableBookDTO() {
	}

	public ExternalizableBookDTO(int numberOfPages, String name) {
		this.numberOfPages = numberOfPages;
		this.name = name;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		this.name = in.readUTF();
		this.numberOfPages = in.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(numberOfPages);
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

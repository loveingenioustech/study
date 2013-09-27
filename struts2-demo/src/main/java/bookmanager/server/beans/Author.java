package bookmanager.server.beans;

public class Author {

	Integer author_id;
	String lname;
	String fname;
	Integer yob;
	Integer yod;

	public Integer getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Integer authorId) {
		author_id = authorId;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Integer getYob() {
		return yob;
	}

	public void setYob(Integer yob) {
		this.yob = yob;
	}

	public Integer getYod() {
		return yod;
	}

	public void setYod(Integer yod) {
		this.yod = yod;
	}
}

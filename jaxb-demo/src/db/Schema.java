package db;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Schema {
	private String user;
	private String password;
	private String url;
	private String driver;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public Schema(String user, String password, String url, String driver) {
		super();
		this.user = user;
		this.password = password;
		this.url = url;
		this.driver = driver;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this).appendSuper(super
				.toString());
		builder.append("user", user).append("password", password)
				.append("url", url).append("driver", driver);
		return builder.toString();
	}

}

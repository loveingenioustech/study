package bookmanager.client.action;

import java.util.Map;

import bookmanager.server.beans.BooklookUser;
import bookmanager.server.services.PasswordEncrypter;
import bookmanager.server.services.Persistence;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	String username;
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();

		String encryptedPassword = PasswordEncrypter.encrypt(password);
		BooklookUser user = Persistence.getInstance().getUser(username,
				encryptedPassword);
		if (user == null) {
			session.put("LOGINSUCCESS", "false");
			return ERROR;
		}

		session.put("LOGINSUCCESS", "true");
		session.put("USER", user);

		return SUCCESS;
	}

}

package bookmanager.client.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LogoutAction extends ActionSupport {
	public String execute() throws Exception {
		ActionContext.getContext().getSession().remove("USER");
		return LOGIN;
	}

}

package bookmanager.client.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddBookScreenAction extends ActionSupport {

	private List<String> bindings = null;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public List<String> getBindings() {
		if (bindings == null) {
			bindings = new ArrayList<String>();
			bindings.add("Trade");
			bindings.add("Hardcover");
			bindings.add("Paperback");
			bindings.add("eBook");
			bindings.add("Other");
		}

		return bindings;
	}
}

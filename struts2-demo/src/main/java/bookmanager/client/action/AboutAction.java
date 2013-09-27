package bookmanager.client.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AboutAction extends ActionSupport {
	private String versionNumber = "0.3";
	private String buildNumber = "1.0";

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

}

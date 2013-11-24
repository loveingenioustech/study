/**
 * 
 */
package com.jgeppert.examples.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author binlong
 * 
 */
public class YourNameAction extends ActionSupport {

	private String name;

	public String execute() throws Exception {
		if (name == null || name.length() < 3) {
			addActionError("Please enter valid name with more the 2 characters!");
			return ERROR;
		}

		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

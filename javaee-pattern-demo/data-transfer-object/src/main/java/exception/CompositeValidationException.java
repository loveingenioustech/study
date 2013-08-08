package exception;

import java.util.HashMap;
import java.util.Map;

public class CompositeValidationException extends Exception {

	private String name;

	private Map<String, ValidationException> validationExceptions = new HashMap<String, ValidationException>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompositeValidationException(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(String key, ValidationException ex) {
		validationExceptions.put(key, ex);
	}

	public boolean isEmpty() {
		return this.validationExceptions.isEmpty();
	}

}

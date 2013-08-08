package exception;

public class ValidationException extends Exception {

	private String regExp;

	private String content;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String regExp, String contentAsString) {
		this.regExp = regExp;
		this.content = contentAsString;
	}

}

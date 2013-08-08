package type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.ValidationException;

public abstract class AbstractType<T> implements Attribute<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T t = null;

	protected String regExp;

	private String contentAsString = null;

	private boolean id = false;

	private Pattern p = null;

	private Matcher m = null;

	public AbstractType(String regExp) {
		this.setRegexp(regExp);
	}

	protected abstract T construct(String content);

	@Override
	public void validate() throws ValidationException {
		if (this.regExp != null) {
			m = p.matcher(this.contentAsString);
			boolean valid = m.matches();
			if (!valid) {
				throw new ValidationException(this.regExp, this.contentAsString);
			}
		}
	}

	@Override
	public void instantiateFromString(String content) {
		this.contentAsString = content;
		t = construct(content);
	}

	@Override
	public void setRegexp(String regExp) {
		this.regExp = regExp;
		compileRegexp();
	}

	private void compileRegexp() {
		if (this.regExp != null) {
			p = Pattern.compile(this.regExp);
		}
	}

	@Override
	public void setId() {
		this.id = true;
	}

	@Override
	public T getValue() {
		return t;
	}

	@Override
	public boolean isId() {
		return this.id;
	}

}

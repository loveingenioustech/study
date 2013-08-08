package type;

import java.io.Serializable;

import exception.ValidationException;


public interface Attribute<T> extends Serializable {
	public void validate() throws ValidationException;

	public void instantiateFromString(String content);

	public void setRegexp(String regExp);

	public void setId();

	public T getValue();

	public boolean isId();
}

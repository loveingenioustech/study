package type;

public class StringType extends AbstractType<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StringType(String regExp) {
		super(regExp);
	}

	public StringType(String regExp, String contentAsString) {
		super(regExp);
		this.instantiateFromString(contentAsString);
	}

	public StringType() {
		this(null);
	}

	@Override
	protected String construct(String content) {
		return content;
	}

}

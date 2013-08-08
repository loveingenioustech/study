package type;

public class IntType extends AbstractType<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntType(String regExp) {
		super(regExp);
	}

	public IntType(String regExp, String contentAsString) {
		super(regExp);
		this.instantiateFromString(contentAsString);
	}

	public IntType() {
		this(null);
	}

	protected Integer construct(String content) {
		return Integer.parseInt(content);
	}

}

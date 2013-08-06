package singleton;

import java.io.Serializable;

public class DemoSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private volatile static DemoSingleton instance = null;

	private String identifier = "1000";

	private DemoSingleton() {
		// Check if we already have an instance
		// if (instance != null) {
		// throw new IllegalStateException("Hey Man, DemoSingleton"
		// + " instance already created.");
		// }
	}

	public static DemoSingleton getInstance() {
		if (instance == null) {
			instance = new DemoSingleton();
		}
		return instance;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	protected Object readResolve() {
		return getInstance();
	}
}

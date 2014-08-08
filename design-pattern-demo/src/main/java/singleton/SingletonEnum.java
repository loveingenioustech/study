package singleton;

/*
 * 
 *Java 5 introduced the Enumtype. If you create the Singletonas a single-element Enum, the JVM 
 guaranteesthat only one instance will ever be created
 */
public enum SingletonEnum {
	INSTANCE;

	public void singletonMethod() {
		// operations here
	}
}

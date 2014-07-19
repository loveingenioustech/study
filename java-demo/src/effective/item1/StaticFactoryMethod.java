package effective.item1;

import java.util.HashMap;

public class StaticFactoryMethod {
	/*
	 * One advantage of static factory methods is that, unlike constructors,
	 * they have names.
	 * 
	 * A second advantage of static factory methods is that, unlike
	 * constructors, they are not required to create a new object each time
	 * they¡¯re invoked.
	 * 
	 * A third advantage of static factory methods is that, unlike constructors,
	 * they can return an object of any subtype of their return type.
	 * 
	 * A fourth advantage of static factory methods is that they reduce the
	 * verbosity of creating parameterized type instances.
	 * 
	 * 
	 * The main disadvantage of providing only static factory methods is that
	 * classes without public or protected constructors cannot be subclassed.
	 * 
	 * A second disadvantage of static factory methods is that they are not
	 * readily distinguishable from other static methods.
	 */

	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}

	public static <K, V> HashMap<K, V> newInstance() {
		return new HashMap<K, V>();
	}

	// Map<String, List<String>> m = HashMap.newInstance();
}

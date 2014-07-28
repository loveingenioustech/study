package loader;

public class SimpleClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		SimpleClassLoader firstClassLoader = new SimpleClassLoader(
				"C:/Dev/TestClasses");
		Class c1 = firstClassLoader.loadClass("loader.ConstructOnce");
		
		SimpleClassLoader secondClassLoader = new SimpleClassLoader(
				"C:/Dev/TestClasses");		
		Class c2 = secondClassLoader.loadClass("loader.ConstructOnce");
		
		System.out.println("First c1.newInstance()");		
		Object x = c1.newInstance();
		
		try {
			System.out.println("Second c1.newInstance()");					
			Object y = c1.newInstance();
			throw new RuntimeException("Test fails");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		System.out.println("First c2.newInstance()");		
		Object z = c2.newInstance();
	}

}

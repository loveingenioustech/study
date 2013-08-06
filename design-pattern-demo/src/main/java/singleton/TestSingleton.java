package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {

	static DemoSingleton instanceOne = DemoSingleton.getInstance();

	public static void main(String[] args) {

		TestSingleton testSingleton = new TestSingleton();
		// testSingleton.testDeserialize();

		testSingleton.testReflection();

		// testSingleton.testReflection2();

		// testSingleton.testSecurityManager();
	}

	private void testReflection() {
		Class clazz = DemoSingleton.class;

		Constructor cons;
		try {
			cons = clazz.getDeclaredConstructor();
			cons.setAccessible(true);

			DemoSingleton instanceTwo = (DemoSingleton) cons.newInstance();

			instanceTwo.setIdentifier("2000");

			System.out.println("This is the value of instance one: "
					+ instanceOne.getIdentifier());
			System.out.println("This is the value of instance two: "
					+ instanceTwo.getIdentifier());

		} catch (SecurityException e) {
			System.out.println("---SecurityException---");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("---NoSuchMethodException---");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("---IllegalArgumentException---");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("---InstantiationException---");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("---IllegalAccessException---");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("---InvocationTargetException---");
			e.printStackTrace();
		}

	}

	private void testReflection2() {
		// Class clazz = DemoSingleton.class;
		Constructor cons;

		try {

			Class clazz = Class.forName("demo.DemoSingleton");

			// cons = clazz.getConstructors()[0];
			cons = clazz.getDeclaredConstructor();
			cons.setAccessible(true);

			DemoSingleton instanceTwo = (DemoSingleton) clazz.newInstance();

			instanceTwo.setIdentifier("2000");

			System.out.println("This is the value of instance one: "
					+ instanceOne.getIdentifier());
			System.out.println("This is the value of instance two: "
					+ instanceTwo.getIdentifier());

		} catch (SecurityException e) {
			System.out.println("---SecurityException---");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("---IllegalArgumentException---");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("---InstantiationException---");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("---IllegalAccessException---");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("---ClassNotFoundException---");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("---NoSuchMethodException---");
			e.printStackTrace();
		}
	}

	private void testSecurityManager() {
		SecurityManager mgr = new SecurityManager();
		System.setSecurityManager(mgr);

		Class clazz = DemoSingleton.class;

		Constructor cons;
		try {
			cons = clazz.getDeclaredConstructor();
			cons.setAccessible(true);

			DemoSingleton instanceTwo = (DemoSingleton) cons.newInstance();

			instanceTwo.setIdentifier("2000");

			System.out.println("This is the value of instance one: "
					+ instanceOne.getIdentifier());
			System.out.println("This is the value of instance two: "
					+ instanceTwo.getIdentifier());

		} catch (SecurityException e) {
			System.out.println("---SecurityException---");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("---NoSuchMethodException---");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("---IllegalArgumentException---");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("---InstantiationException---");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("---IllegalAccessException---");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("---InvocationTargetException---");
			e.printStackTrace();
		}
	}

	private void testDeserialize() {
		try {
			// Serialize to a file
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
					"filename.ser"));
			out.writeObject(instanceOne);
			out.close();

			instanceOne.setIdentifier("2000");

			// Serialize to a file
			ObjectInput in = new ObjectInputStream(new FileInputStream(
					"filename.ser"));
			DemoSingleton instanceTwo = (DemoSingleton) in.readObject();
			in.close();

			System.out.println("This is the value of instance one: "
					+ instanceOne.getIdentifier());
			System.out.println("This is the value of instance two: "
					+ instanceTwo.getIdentifier());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

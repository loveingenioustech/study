package core;

import java.util.*;

/**
 * This program prints out all system properties.
 */
public class SystemInfoDemo {
	public static void main(String args[]) {
		Properties systemProperties = System.getProperties();
		Enumeration enum1 = systemProperties.propertyNames();

		while (enum1.hasMoreElements()) {
			String key = (String) enum1.nextElement();
			System.out.println(key + "=" + systemProperties.getProperty(key));
		}
	}
}

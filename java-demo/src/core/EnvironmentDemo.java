package core;

import java.util.*;

public class EnvironmentDemo {
	public static void main(String[] args) {
		EnvironmentDemo demo = new EnvironmentDemo();

		// demo.showVariables();

		demo.showProperties();
	}

	private void showProperties() {
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
	}

	private void showVariables() {
		for (Map.Entry entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}

package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableDemo {

	public static void main(String[] args) {

		SerializableDemo serializableDemo = new SerializableDemo();

		Person person = new Person();
		person.setAge(20);
		person.setGender("M".charAt(0));
		person.setName("Robin");

		serializableDemo.testSerialize(person);

		serializableDemo.testDeserialize("testSerialize.ser");
	}

	private void testDeserialize(String fileName) {
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));

			Person dPerson = (Person) in.readObject();

			System.out.println(dPerson.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void testSerialize(Object obj) {
		ObjectOutputStream out;

		try {
			out = new ObjectOutputStream(new FileOutputStream(
					"testSerialize.ser"));
			out.writeObject(obj);

			out.close();

			System.out.println("Serialize successfully!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

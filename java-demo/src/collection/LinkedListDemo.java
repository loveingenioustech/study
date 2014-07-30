package collection;

public class LinkedListDemo<E> {
	private static class Element<E> {
		E value;
		Element<E> next;
	}

	private Element<E> head;
}
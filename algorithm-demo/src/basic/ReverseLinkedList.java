package basic;

public class ReverseLinkedList<T> {
	private T element;
	private ReverseLinkedList<T> next;

	public ReverseLinkedList(T element, ReverseLinkedList<T> next) {
		this.element = element;
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public ReverseLinkedList<T> getNext() {
		return next;
	}

	public static <T> ReverseLinkedList<T> reverse(
			final ReverseLinkedList<T> original) {
		if (original == null) {
			throw new NullPointerException("Cannot reverse a null list");
		}
		if (original.getNext() == null) {
			return original;
		}
		final ReverseLinkedList<T> next = original.next;
		original.next = null;
		final ReverseLinkedList<T> othersReversed = reverse(next);
		next.next = original;
		return othersReversed;
	}
}

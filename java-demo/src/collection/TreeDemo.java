package collection;

public class TreeDemo<E extends Comparable> {
	private E value;
	private TreeDemo<E> left;
	private TreeDemo<E> right;

	// constructors, getters and setters omitted

	public boolean search(final E toFind) {
		if (toFind.equals(value)) {
			return true;
		}
		if (toFind.compareTo(value) < 0 && left != null) {
			return left.search(toFind);
		}
		return right != null && right.search(toFind);
	}

	// public void insert(final E toInsert) {
	// if (toInsert.compareTo(value) < 0) {
	// if (left == null) {
	// left = new TreeDemo<>(toInsert, null, null);
	// } else {
	// left.insert(toInsert);
	// }
	// } else {
	// if (right == null) {
	// right = new TreeDemo<>(toInsert, null, null);
	// } else {
	// right.insert(toInsert);
	// }
	// }
	// }
}

package collection;

import java.util.LinkedList;
import java.util.List;

public class SimpleStack {
	private final List values;

	public SimpleStack() {
		values = new LinkedList();
	}

	public void push(final Object object) {
		values.add(0, object);
	}

	public Object pop() {
		if (values.size() == 0) {
			return null;
		}
		return values.remove(0);
	}
}

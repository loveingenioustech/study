package collection;

// What you can do with a TreeSet.
import java.util.*;
import static util.Print.*;

public class SortedSetDemo {
	public static void main(String[] args) {
		SortedSet<String> sortedSet = new TreeSet<String>();
		Collections.addAll(sortedSet,
				"one two three four five six seven eight".split(" "));

		print(sortedSet);

		String low = sortedSet.first();
		String high = sortedSet.last();

		print(low);
		print(high);

		Iterator<String> it = sortedSet.iterator();

		for (int i = 0; i <= 6; i++) {
			if (i == 3)
				low = it.next();
			if (i == 6)
				high = it.next();
			else
				it.next();
		}
		print(low);
		print(high);
		print(sortedSet.subSet(low, high));
		print(sortedSet.headSet(high));
		print(sortedSet.tailSet(low));
	}
}
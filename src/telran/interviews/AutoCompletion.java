package telran.interviews;

import java.util.*;

public class AutoCompletion {
	TreeSet<String> set = new TreeSet<>(String::compareToIgnoreCase);

	public boolean addWord(String word) {
		return set.add(word);
	}

	public String[] getVariants(String prefix) {
		SortedSet<String> subset = set.subSet(prefix, prefix + Character.MAX_VALUE);
		Comparator<String> cmp = Comparator.comparingInt(String::length);
		return subset.stream().sorted(cmp).toArray(String[]::new);
	}
}

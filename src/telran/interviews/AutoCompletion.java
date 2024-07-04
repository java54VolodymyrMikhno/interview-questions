package telran.interviews;

import java.util.*;

public class AutoCompletion {
	TreeSet<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

	public boolean addWord(String word) {
		return words.add(word);
	}

	public String[] getVariants(String prefix) {
		return words.subSet(prefix, prefix + Character.MAX_VALUE).toArray(String[]::new);
	}
}

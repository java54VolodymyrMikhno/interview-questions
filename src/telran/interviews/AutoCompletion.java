package telran.interviews;

import java.util.*;

public class AutoCompletion {
    LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
    TreeSet<String> set = new TreeSet< String>(String::compareToIgnoreCase);
    
	public boolean addWord(String word) {
        set.add( word);
		return linkedHashSet.add(word);
	}
	public String[] getVariants(String prefix) {
         return set.subSet(prefix, prefix+Character.MAX_VALUE).toArray(new String[0]);
	}
}

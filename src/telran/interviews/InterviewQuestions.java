package telran.interviews;

import java.util.*;

public class InterviewQuestions {
	public static void displayOccurrences(String[] strings) {
		HashMap<String, Integer> mapOccurences = getOccurrencesMap(strings);
		TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeOccurences(mapOccurences);
		displayOccurrences(treeMapOccurrences);
	}

	

	private static TreeMap<Integer, TreeSet<String>> getTreeOccurences(HashMap<String, Integer> mapOccurences) {
		TreeMap<Integer,TreeSet<String>> result = new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
		mapOccurences.entrySet()
		.forEach(e->result.computeIfAbsent(e.getValue(),k->new TreeSet<>()).add(e.getKey()));
		return result;
	}



	private static HashMap<String, Integer> getOccurrencesMap(String[]strings) {
		HashMap<String,Integer> result = new HashMap<>();
		for(String str :strings) {
			result.merge(str, 1, Integer::sum);
		}
		return result;
		
	}

	public static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
		treeMapOccurrences.entrySet().forEach(e -> {
			e.getValue().forEach(str-> System.out.printf("%s => %d\n",str,e.getKey()));
		});

	}
}

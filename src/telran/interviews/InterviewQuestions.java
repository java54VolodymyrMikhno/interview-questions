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
	static public boolean isSum2(int [] array, int sum) {
		//TODO returns true if a given array contains two numbers, the summing of which
		//equals a given 'sum' value
		//complexity O[N] only one pass over the elements
		return false;
	}
	static public int getMaxWithNegativePresentation(int [] array) {
		//TODO returns maximal positive value for which exists negative one with the same abs value
		//if no pair of positive and negative values with the same abs value the method returns -1
		//complexity O[N] only one pass over the elements
		return -1;
	}
}

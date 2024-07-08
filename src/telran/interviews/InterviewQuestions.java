package telran.interviews;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class InterviewQuestions {
	private static final long N_NUMBERS = 1000000;

	public static void displayOccurrences(String[] strings) {
		HashMap<String, Integer> mapOccurrences = getOccurrencesMap(strings);
		TreeMap<Integer, TreeSet<String>> treeMapOccurrences = getTreeMapOccurrences(mapOccurrences);
		displayOccurrences(treeMapOccurrences);
	}

	public static void displayOccurrencesStream(String[] strings) {
		Arrays.stream(strings).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.sorted((e1, e2) -> {
					int res = Long.compare(e2.getValue(), e1.getValue());
					return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
				}).forEachOrdered(e -> System.out.printf("%s => %d\n", e.getKey(), e.getValue()));
	}

	private static void displayOccurrences(TreeMap<Integer, TreeSet<String>> treeMapOccurrences) {
		treeMapOccurrences.entrySet().forEach(e -> {
			e.getValue().forEach(str -> System.out.printf("%s => %d\n", str, e.getKey()));
		});

	}

	private static TreeMap<Integer, TreeSet<String>> getTreeMapOccurrences(HashMap<String, Integer> mapOccurrences) {
		TreeMap<Integer, TreeSet<String>> result = new TreeMap<Integer, TreeSet<String>>(Comparator.reverseOrder());
		mapOccurrences.entrySet()
				.forEach(e -> result.computeIfAbsent(e.getValue(), k -> new TreeSet<>()).add(e.getKey()));

		return result;
	}

	private static HashMap<String, Integer> getOccurrencesMap(String[] strings) {
		HashMap<String, Integer> result = new HashMap<>();
		for (String str : strings) {
			result.merge(str, 1, Integer::sum);
		}
		return result;
	}

	static public boolean isSum2(int[] array, int sum) {
		// returns true if a given array contains two numbers, the summing of which
		// equals a given 'sum' value
		// complexity O[N] only one pass over the elements
		HashSet<Integer> helper = new HashSet<>();
		int index = 0;
		while (index < array.length && !helper.contains(sum - array[index])) {
			helper.add(array[index++]);
		}
		return index < array.length;
	}

	static public int getMaxWithNegativePresentation(int[] array) {
		// returns maximal positive value for which exists negative one with the same
		// abs value
		// if no pair of positive and negative values with the same abs value the method
		// returns -1
		// complexity O[N] only one pass over the elements
		int maxRes = -1;
		HashSet<Integer> helper = new HashSet<>();
		for (int num : array) {
			if (helper.contains(-num)) {
				maxRes = Math.max(maxRes, Math.abs(num));
			} else {
				helper.add(num);
			}
		}
		return maxRes;
	}

	public static Map<Integer, Integer> getMapSquares(List<Integer> numbers) {
		Map<Integer, Integer> res = numbers.stream()
				.collect(Collectors.toMap(n -> n, n -> n * n, (v1, v2) -> v1, LinkedHashMap::new));
		return res;
	}

	public static boolean isAnagram(String word, String anagram) {
		boolean res = false;
		if (word.length() == anagram.length() && !Objects.equals(word, anagram)) {

			Map<Integer, Long> map = word.chars().collect(HashMap::new, (m, c) -> m.merge(c, 1L, Long::sum),
					HashMap::putAll);
			res = anagram.chars().allMatch(c -> map.merge(c, -1L, Long::sum) >= 0);
		}
		return res;
	}

	public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory, List<LocalDate> dates) {
		TreeMap<LocalDate, String> roleMap = rolesHistory.stream()
				.collect(Collectors.toMap(r -> r.date(), r -> r.role(), (v1, v2) -> v1, TreeMap::new));
		return dates.stream().map(date -> new DateRole(date, getRoleForDate(roleMap, date))).collect(toList());

	}

	private static String getRoleForDate(TreeMap<LocalDate, String> roleMap, LocalDate date) {
		return roleMap.floorEntry(date) == null ? null : roleMap.floorEntry(date).getValue();
	}

	public static void displayDigitsStatistics() {
		// TODO
		// display out statistics in the following format(example)
		// 1-><count of occurrences>
		// 2-><count of occurrences>
		// 3-><count of occurrences>
		// sorted by counts of occurrences in the descending order
		// takes 1000000 random numbers in range[0-Integer.MAX_VALUE]
		// one pipeline with no additional yours methods
		new Random().ints(N_NUMBERS, 0, Integer.MAX_VALUE).flatMap(n -> String.valueOf(n).chars())
				.mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet()
				.stream().sorted((e, e1) -> e1.getValue().compareTo(e.getValue()))
				.forEach(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));

	}

}
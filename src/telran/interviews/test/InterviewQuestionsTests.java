package telran.interviews.test;

import org.junit.jupiter.api.Test;

import telran.interviews.DateRole;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.interviews.InterviewQuestions.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class InterviewQuestionsTests {

	private static final LocalDate DATE2 = LocalDate.of(2021, 10, 30);
	private static final LocalDate DATE1 = LocalDate.of(2019, 12, 31);
	private static final LocalDate DATE3 = LocalDate.of(2021, 12, 30);
	private static final LocalDate DATE4 = LocalDate.of(2024, 1, 1);
	String ROLE1 = "Developer";
	String ROLE2 = " Senior Developer";
	String ROLE3 = "Manager";

	@Test
	void displayOccurencesTest() {
		String[] strings = { "bb", "bb", "a", "aa", "lmn", "aa", "lmn", "lmn" };
		displayOccurrences(strings);
		// Should be displayed out following:
		/*
		 * lmn->3 aa->2 a->1 b->1
		 */
	}

	@Test
	void displayOccurencesStreamTest() {
		String[] strings = { "bb", "bb", "a", "aa", "lmn", "aa", "lmn", "lmn" };
		displayOccurrencesStream(strings);
		// Should be displayed out following:
		/*
		 * lmn->3 aa->2 a->1 b->1
		 */
	}

	@Test
	void isSum2Test() {
		int[] array = { -10, 2, 40, -30 };
		assertTrue(isSum2(array, 30));
		assertFalse(isSum2(array, 32));
	}

	@Test
	void maxPositiveWithNegativeTest() {
		int[] array1 = { -200, 10, -10, 1, 2, 3, -3, 200 };
		int[] array2 = { -200, -200, 100, 10, 10 };
		assertEquals(200, getMaxWithNegativePresentation(array1));
		assertEquals(-1, getMaxWithNegativePresentation(array2));
	}

	@Test
	void evenOddGrouping() {
		List<Integer> list = List.of(10, -3, 22, 41, 56, 7);
		Map<String, List<Integer>> groupingMap = list.stream()
				.collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
		System.out.println(groupingMap);

	}

	@Test
	void evenOddCounts() {
		List<Integer> list = List.of(10, -3, 22, 41, 56, 7, 3);
		Map<String, Long> groupingMap = list.stream()
				.collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd", Collectors.counting()));
		System.out.println(groupingMap);
	}

	@Test
	void getMapSquaresTest() {
		Integer[] numbers = { 20, 10, -2, 5, 7, -2 };
		Map<Integer, Integer> actualMap = getMapSquares(List.of(numbers));
		Integer[] expectedValues = { 400, 100, 4, 25, 49 };
		Integer[] actualValues = actualMap.values().toArray(Integer[]::new);
//		Arrays.sort(actualValues);
		assertArrayEquals(expectedValues, actualValues);
	}

	@Test
	void isAnagramTest() {
		String word = "hello";
		assertTrue(isAnagram(word, "elloh"));
		assertTrue(isAnagram(word, "hleoh"));
		assertTrue(isAnagram(word, "hleohl"));
		assertFalse(isAnagram(word, word));
		assertFalse(isAnagram(word, "olle"));
		assertFalse(isAnagram(word, "ollhh"));
		assertFalse(isAnagram(word, "olehd"));

	}

	@Test
	void assignRoleDatesTest() {
		List<DateRole> history = List.of(new DateRole(LocalDate.of(2020, 1, 1), ROLE1),
				new DateRole(LocalDate.of(2021, 1, 1), ROLE2), new DateRole(LocalDate.of(2022, 1, 1), ROLE3));
		List<LocalDate> dates = List.of(DATE1, DATE2, DATE3, DATE4);
		List<DateRole> expected = List.of(new DateRole(DATE1, null), new DateRole(DATE2, ROLE2),
				new DateRole(DATE3, ROLE2), new DateRole(DATE4, ROLE3));
		assertIterableEquals(expected, assignRoleDates(history, dates));
	}
	@Test
	void displayDigitsStatistucsTest() {
		displayDigitsStatistics();
	}

}

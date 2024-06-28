package telran.interviews.test;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.interviews.InterviewQuestions.*;
class InterviewQuestionsTests {

	@Test
	void displayOccurencesTest() {
		String[]strings = {"bb","bb","a","aa","lmn","aa","lmn","lmn"};
		displayOccurrences(strings);
		//Should be displayed out following:
		/*
		 * lmn->3
		 * aa->2
		 * a->1
		 * b->1
		 */
	}
	@Test
	void isSum2Test() {
		int [] array = {-10, 2, 40, -30};
		assertTrue(isSum2(array, 30));
		assertFalse(isSum2(array, 32));
	}
	@Test
	void maxPositiveWithNegativeTest() {
		int[] array1 = {-200, 10, -10, 1, 2, 3, -3, 200};
		int [] array2 = {-200, -200, 100, 10, 10};
		assertEquals(200, getMaxWithNegativePresentation(array1));
		assertEquals(-1, getMaxWithNegativePresentation(array2));
	}

}

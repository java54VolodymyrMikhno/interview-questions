package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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

}

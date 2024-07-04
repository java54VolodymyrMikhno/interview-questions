package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.interviews.MyStackInt;

class MyStackIntTest {
	private static final long N_ELEMENTS = 1000;
	MyStackInt stack;

	@BeforeEach
	void setUp() {
		stack = new MyStackInt();
	}

	@Test
	void testPush() {
		stack.push(100);
		assertEquals(100, stack.getMaxElement());
		stack.push(200);
		assertEquals(200, stack.getMaxElement());
		stack.push(200);
		assertEquals(200, stack.getMaxElement());
		stack.pop();
		assertEquals(200, stack.getMaxElement());
		stack.pop();
		assertEquals(100, stack.getMaxElement());
	}

	@Test
	void testPeek() {
		assertThrowsExactly(EmptyStackException.class, () -> stack.peek());
		stack.push(100);
		assertEquals(100, stack.peek());
	}

	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push(0);
		assertFalse(stack.isEmpty());
	}

	@Test
	void testGetMaxElements() {
		int[] randomAr = new Random().ints().limit(N_ELEMENTS).toArray();
		TreeSet<Integer> treeset = new TreeSet<>();
		assertThrowsExactly(EmptyStackException.class, () -> stack.getMaxElement());
		for (int num : randomAr) {
			stack.push(num);
			treeset.add(num);
		}
		assertEquals(treeset.last(), stack.getMaxElement());
	}
}
package telran.interviews;

import java.util.*;

public class MyStackInt {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> maxes = new Stack<>();

	public void push(int num) {
		stack.push(num);
		if (maxes.empty() || num >= maxes.peek()) {
			maxes.push(num);
		}
	}

	public int pop() {
		int res = stack.pop();
		if (res == maxes.peek()) {
			maxes.pop();
		}
		return res;
	}

	public int peek() {
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int getMaxElement() {
		return maxes.peek();
	}
}
package telran.interviews;
//All methods should have complexity O[1]

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackInt {
LinkedList<Integer> stack = new LinkedList<>();
LinkedList<Integer> maxStack = new LinkedList<>();
	public void push(int num) {
		stack.push(num);
		if(maxStack.isEmpty()|| num>= maxStack.peek()) {
			maxStack.push(num);
		}
	}
	public int pop() {
		isEmptyException();
		int res = stack.pop();	
		if(res == maxStack.peek()) {
			maxStack.pop();
		}
		return res;}
	public int peek() {
		isEmptyException();
		return stack.peek();
	}
	public boolean isEmpty() {
		
		return stack.isEmpty();
	}
	public int getMaxElement() {
		isEmptyException();
		return maxStack.peek();
	}
	private void isEmptyException() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
	}
}
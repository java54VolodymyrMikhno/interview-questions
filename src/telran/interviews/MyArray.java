package telran.interviews;

import java.util.*;

//all methods must have complexity O[1]
public class MyArray<T> {
	Map<Integer, T> map;
	int size;
	T defaultValue;

	public MyArray(int size) {
		this.size = size;
		this.map = new HashMap<>();
	}

	public void setAll(T value) {
		map.clear();
		defaultValue = value;
	}

	public void set(int index, T value) {
		checkIndex(index);
		map.put(index, value);
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public T get(int index) {
		checkIndex(index);
		return map.getOrDefault(index, defaultValue);
	}

}
package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.MyArray;

class MyArrayTest {
    private MyArray<Integer> array;

    @BeforeEach
    void setUp() {
        array = new MyArray<>(5);
    }
@Test
void test() {
	array.set(0, 10); array.setAll(5);
	assertEquals(5, array.get(0));
	
}
    @Test
    void testSetAndGet() {
        array.set(0, 10);
        array.set(1, 20);
        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
    }

    @Test
    void testSetAll() {
        array.setAll(5);
        for (int i = 0; i < 5; i++) {
            assertEquals(5, array.get(i));
        }
    }

    @Test
    void testSetOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.set(5, 10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.set(-1, 10));
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(5));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.get(-1));
    }
}

package telran.interviews.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.*;

import telran.interviews.MyStackInt;

public class MyStackIntTest {
    private MyStackInt stack;
    private MyStackInt emptyStack;

    @BeforeEach
    public void setUp() {
        stack = new MyStackInt();
        emptyStack = new MyStackInt();
    }

    @Test
    public void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
        assertThrows(EmptyStackException.class, () -> emptyStack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(30);
        stack.push(40);
        assertEquals(40, stack.peek());
        assertEquals(40, stack.peek()); 
        assertEquals(40, stack.pop()); 
        assertThrows(EmptyStackException.class, () -> emptyStack.peek());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(50);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testGetMaxElement() {
        stack.push(5);
        stack.push(10);
        stack.push(15);
        assertEquals(15, stack.getMaxElement());
        stack.pop();
        assertEquals(10, stack.getMaxElement());
        stack.pop();
        assertEquals(5, stack.getMaxElement());
        stack.pop();
        assertThrows(EmptyStackException.class, () -> stack.getMaxElement());
    }

}

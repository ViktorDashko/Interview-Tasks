package task3Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task3.TSStack;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class TSStackIntegerTest {

    private TSStack<Integer> stack;

    private static Integer expected3 = new Integer(3456);
    private static Integer expected2 = new Integer(4567);
    private static Integer expected1 = new Integer(5896);

    @Before
    public void setUp() throws Exception {
        stack = new TSStack<Integer>() {{
            push(expected3);
            push(expected2);
            push(expected1);
        }};
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void push() {
        assertTrue(stack.push(5));
    }

    @Test
    public void peek() {
        int actual1 = stack.peek();
        int actual2 = stack.peek();
        int actual3 = stack.peek();
        int expected = expected1;
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
    }

    @Test
    public void pop() {
        Integer actual1 = stack.pop();
        Integer actual2 = stack.pop();
        Integer actual3 = stack.pop();
        assertSame(expected1, actual1);
        assertSame(expected2, actual2);
        assertSame(expected3, actual3);
    }

    @Test(expected = EmptyStackException.class)
    public void pop2() {
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void isEmpty() {
        assertFalse(stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void size() {
        int expected = 3;
        int actual = stack.size();
        assertEquals(expected, actual);
    }
}
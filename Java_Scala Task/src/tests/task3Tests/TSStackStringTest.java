package task3Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task3.TSStack;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class TSStackStringTest {
    private TSStack<String> stack;
    private static String expected3 = new String("test3");
    private static String expected2 = new String("test2");
    private static String expected1 = new String("test1");
    @Before
    public void setUp() throws Exception {
        stack = new TSStack<String>(){{
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
        assertTrue(stack.push("one more string"));
    }


    @Test
    public void peek() {
        String actual1 = stack.peek();
        String actual2 = stack.peek();
        String actual3 = stack.peek();
        assertEquals(expected1, actual1);
        assertEquals(expected1, actual2);
        assertEquals(expected1, actual3);
    }

    @Test
    public void pop() {
        String actual1 = stack.pop();
        String actual2 = stack.pop();
        String actual3 = stack.pop();
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
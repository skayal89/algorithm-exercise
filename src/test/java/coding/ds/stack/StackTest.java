package coding.ds.stack;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StackTest {

    Stack<Integer> s;

    @Before
    public void setUp() throws Exception {
        s = new Stack<>(Integer.class, 2);
    }

    @Test
    public void push() {
        s.push(10);
        s.push(20);
        assertEquals(2,s.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void pushWithException() {
        s.push(1);
        s.push(2);
        s.push(3);
    }

    @Test
    public void pop() {
        s.push(10);
        s.push(20);
        assertEquals(20,s.pop().intValue());
    }

    @Test(expected = EmptyStackException.class)
    public void popWithException() {
        s.pop();
    }

    @Test
    public void isEmpty() {
        assertTrue(s.isEmpty());
        s.push(1);
        assertFalse(s.isEmpty());
    }

    @Test
    public void isFull() {
        s.push(10);
        assertFalse(s.isFull());
        s.push(20);
        assertTrue(s.isFull());
    }

    @Test
    public void peek() {
        assertNull(s.peek());
        s.push(10);
        assertEquals(10,s.peek().intValue());
        s.push(20);
        assertEquals(20,s.peek().intValue());
    }
}
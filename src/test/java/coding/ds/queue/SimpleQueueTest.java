package coding.ds.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleQueueTest {

    SimpleQueue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new SimpleQueue<>(Integer.class, 2);
    }

    @Test
    public void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.add(1);
        assertFalse(queue.isEmpty());
        queue.add(2);
        queue.poll();
        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void isFull() {
        assertFalse(queue.isFull());
        queue.add(1);
        queue.add(2);
        assertTrue(queue.isFull());
    }

    @Test
    public void getSize() {
    }

    @Test
    public void add() {
        queue.add(1);
        assertEquals(1,queue.peek().intValue());
        queue.add(2);
        assertEquals(1,queue.peek().intValue());
        assertEquals(1,queue.poll().intValue());
        assertEquals(2,queue.peek().intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithException() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
    }

    @Test
    public void poll() {
        queue.add(1);
        assertEquals(1,queue.peek().intValue());
        queue.add(2);
        assertEquals(1,queue.poll().intValue());
        assertEquals(2,queue.poll().intValue());
        assertTrue(queue.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void pollWithException() {
        queue.add(1);
        assertEquals(1,queue.peek().intValue());
        queue.add(2);
        assertEquals(1,queue.poll().intValue());
        assertEquals(2,queue.poll().intValue());
        queue.poll();
    }
}
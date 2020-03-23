package coding.ds.queue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CircularQueueTest {

    CircularQueue<Integer> circularQueue;

    @Before
    public void setUp() throws Exception {
        circularQueue = new CircularQueue<>(Integer.class, 3);
    }

    @Test
    public void isEmpty() {
        assertTrue(circularQueue.isEmpty());
        circularQueue.add(1);
        assertFalse(circularQueue.isEmpty());
    }

    @Test
    public void isFull() {
        assertFalse(circularQueue.isFull());
        circularQueue.add(1);
        circularQueue.add(2);
        circularQueue.add(3);
        assertTrue(circularQueue.isFull());
        circularQueue.remove();
        assertFalse(circularQueue.isFull());
    }

    @Test
    public void add() {
        assertNull(circularQueue.peek());
        circularQueue.add(1);
        circularQueue.add(2);
        assertEquals(2,circularQueue.peek().intValue());
        circularQueue.add(3);
        assertEquals(3,circularQueue.peek().intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithException() {
        circularQueue.add(1);
        circularQueue.add(2);
        circularQueue.add(3);
        circularQueue.add(4);
    }

    @Test
    public void remove() {
        circularQueue.add(1);
        circularQueue.add(2);
        assertEquals(2,circularQueue.peek().intValue());
        assertEquals(1, circularQueue.remove().intValue());
        assertEquals(2,circularQueue.peek().intValue());
        circularQueue.add(3);
        circularQueue.add(4);
        assertEquals(2, circularQueue.remove().intValue());
        circularQueue.add(5);
        assertEquals(5,circularQueue.peek().intValue());
    }

    public void size(){
        assertEquals(0,circularQueue.size());
        circularQueue.add(1);
        circularQueue.add(2);
        assertEquals(2,circularQueue.size());
        circularQueue.remove();
        circularQueue.remove();
        assertEquals(0,circularQueue.size());

    }

}
package coding.ds.liknedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    SinglyLinkedList<Integer> linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void add() {
        assertTrue(linkedList.isEmpty());
        linkedList.add(1,0);
        assertEquals(1,linkedList.size());
        assertEquals(linkedList.getFirst(), linkedList.getLast());
        linkedList.add(2,1);
        assertEquals(2,linkedList.getLast().intValue());
        linkedList.add(3,1);
        assertEquals(2,linkedList.getLast().intValue());
        assertEquals(3,linkedList.size());
    }

    @Test
    public void remove() {
        linkedList.add(1,0);
        linkedList.add(2,1);
        linkedList.add(3,2);
        linkedList.add(4,3);
        linkedList.add(5,4);

        assertEquals(5,linkedList.size());
        assertEquals(5,linkedList.getLast().intValue());
        assertTrue(linkedList.remove(1));
        assertEquals(4,linkedList.size());
        assertEquals(2,linkedList.getFirst().intValue());
        assertFalse(linkedList.remove(7));
        assertTrue(linkedList.remove(5));
        assertEquals(3,linkedList.size());
        assertEquals(4,linkedList.getLast().intValue());
        assertTrue(linkedList.remove(3));
        assertEquals(2,linkedList.size());
        assertEquals(4,linkedList.getLast().intValue());
        assertEquals(2,linkedList.getFirst().intValue());
    }

    @Test
    public void size() {
        assertEquals(0,linkedList.size());
        linkedList.add(1,0);
        linkedList.add(2,1);
        linkedList.add(3,2);
        assertEquals(3,linkedList.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(linkedList.isEmpty());
        linkedList.add(1,0);
        assertFalse(linkedList.isEmpty());
        linkedList.removeAll();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void removeAll() {
        assertTrue(linkedList.isEmpty());
        linkedList.add(1,0);
        linkedList.add(2,1);
        linkedList.add(3,2);
        linkedList.removeAll();
        assertTrue(linkedList.isEmpty());
    }
}
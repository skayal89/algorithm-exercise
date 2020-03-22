package coding.ds.array.binarysearch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BinarySearchTest {
    @Spy
    BinarySearch binarySearch;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testBinarySearch() {
        int a[] = new int[]{2,3,7,9,13,22,79};

        assertEquals(2, binarySearch.recrsive(a,0,a.length-1,7));
        assertEquals(0, binarySearch.recrsive(a,0,a.length-1,2));
        assertEquals(6, binarySearch.recrsive(a,0,a.length-1,79));
        assertEquals(4, binarySearch.recrsive(a,0,a.length-1,13));
        assertEquals(-1, binarySearch.recrsive(a,0,a.length-1,113));

        assertEquals(2, binarySearch.iterative(a,7));
        assertEquals(0, binarySearch.iterative(a,2));
        assertEquals(6, binarySearch.iterative(a,79));
        assertEquals(4, binarySearch.iterative(a,13));
        assertEquals(-1, binarySearch.iterative(a,113));
    }

    @Test
    public void testBinarySearchWithSingleElement() {
        int a[] = new int[]{2};
        assertEquals(0, binarySearch.recrsive(a,0,a.length-1,2));
        assertEquals(-1, binarySearch.recrsive(a,0,a.length-1,79));

        assertEquals(0, binarySearch.iterative(a,2));
        assertEquals(-1, binarySearch.iterative(a,79));
    }

    @Test
    public void testBinarySearchWithNullArray() {
        int a[]=null;
        assertEquals(-1, binarySearch.recrsive(a,0,7,79));
        assertEquals(-1, binarySearch.iterative(a,79));
    }

    @Test
    public void testBinarySearchWithDuplicateElements() {
        int a[] = new int[]{2,7,7,10,13,22,22};
        assertEquals(1, binarySearch.recrsive(a,0,a.length-1,7));
        assertEquals(5, binarySearch.recrsive(a,0,a.length-1,22));
        assertEquals(1, binarySearch.iterative(a,7));
        assertEquals(5, binarySearch.iterative(a,22));
    }

    @Test
    public void testBinarySearchWithAllDuplicates() {
        int a[] = new int[]{2,2,2,2,2,2,2};
        assertEquals(-1, binarySearch.recrsive(a,0,a.length-1,7));
        assertEquals(3, binarySearch.recrsive(a,0,a.length-1,2));
        assertEquals(-1, binarySearch.iterative(a,7));
        assertEquals(3, binarySearch.iterative(a,2));
    }
}
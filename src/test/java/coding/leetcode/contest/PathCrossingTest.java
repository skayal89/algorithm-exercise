package coding.leetcode.contest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PathCrossingTest {

    PathCrossing pathCrossing = new PathCrossing();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isPathCrossing() {
        assertTrue(pathCrossing.isPathCrossing("NESWW"));
        assertFalse(pathCrossing.isPathCrossing("NES"));
        assertTrue(pathCrossing.isPathCrossing("NESSWWNNE"));
        assertTrue(pathCrossing.isPathCrossing("NESSWWNE"));
        assertTrue(pathCrossing.isPathCrossing("NSEWESNNN"));
        assertFalse(pathCrossing.isPathCrossing("NNNN"));
        assertFalse(pathCrossing.isPathCrossing("E"));
    }
}
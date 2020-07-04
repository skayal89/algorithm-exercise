package coding.codeforces.contests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RequiredRemainderTest {

    @Test
    public void requiredReminder() {
        assertEquals(12339, RequiredRemainder.requiredReminder(7, 5, 12345));
        assertEquals(0, RequiredRemainder.requiredReminder(5, 0, 4));
        assertEquals(15, RequiredRemainder.requiredReminder(10, 5, 15));
        assertEquals(54306, RequiredRemainder.requiredReminder(17, 8, 54321));
        assertEquals(999999995, RequiredRemainder.requiredReminder(499999993, 9, 1000000000));
        assertEquals(185, RequiredRemainder.requiredReminder(10, 5, 187));
        assertEquals(999999998, RequiredRemainder.requiredReminder(2, 0, 999999999));
        assertEquals(9, RequiredRemainder.requiredReminder(10, 9, 17));
    }
}
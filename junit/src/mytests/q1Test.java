package mytests;

import static org.junit.Assert.*;
import org.junit.Test;

public class q1Test {

    @Test
    public void testFactorialValidInput() {
        assertEquals(120, q1.factorial(5));
        assertEquals(1, q1.factorial(0));
        assertEquals(6, q1.factorial(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegativeInput() {
        q1.factorial(-1);
    }
}

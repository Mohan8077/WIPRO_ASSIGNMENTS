package mytests;

import static org.junit.Assert.*;
import org.junit.Test;

public class q2Test {

    @Test
    public void testReverseEmptyString() {
        assertEquals("", q2.reverse(""));
    }

    @Test
    public void testReverseRegularString() {
        assertEquals("olleh", q2.reverse("hello"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverseNullInput() {
        q2.reverse(null);
    }
}

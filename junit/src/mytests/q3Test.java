package mytests;

import static org.junit.Assert.*;
import org.junit.Test;

public class q3Test {

    @Test
    public void testValidLogin() {
        assertTrue(q3.validateLogin("admin", "password123"));
    }

    @Test
    public void testInvalidLogin() {
        assertFalse(q3.validateLogin("user", "pass"));
    }

    @Test
    public void testEmptyUsername() {
        assertFalse(q3.validateLogin("", "password123"));
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(q3.validateLogin("admin", ""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUsername() {
        q3.validateLogin(null, "password123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassword() {
        q3.validateLogin("admin", null);
    }
}

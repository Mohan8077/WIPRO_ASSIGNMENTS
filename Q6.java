package Junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Q6 {

    // Method to test
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }

    @Test
    public void testDivideValidInput() {
        assertEquals(2, divide(10, 5));     // 10 / 5 = 2
        assertEquals(0, divide(0, 10));     // 0 / 10 = 0
        assertEquals(-5, divide(-10, 2));   // -10 / 2 = -5
    }

    @Test
    public void testDivideByZeroThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            divide(10, 0);
        });
        assertEquals("Divider cannot be zero", exception.getMessage());
    }
}

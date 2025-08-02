package QNO52;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtils {
    static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative not allowed");
        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }
}

public class FactorialTest {
    @Test
    void testValidFactorials() {
        assertEquals(1, MathUtils.factorial(0));
        assertEquals(6, MathUtils.factorial(3));
    }

    @Test
    void testNegativeFactorial() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }
}

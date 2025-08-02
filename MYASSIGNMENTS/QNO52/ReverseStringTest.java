package QNO52;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtils {
    static String reverse(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }
}

public class ReverseStringTest {
    @Test
    void testRegularString() {
        assertEquals("cba", StringUtils.reverse("abc"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    void testNullInput() {
        assertNull(StringUtils.reverse(null));
    }
}

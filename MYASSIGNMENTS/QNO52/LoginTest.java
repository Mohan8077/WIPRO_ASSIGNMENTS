package QNO52;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthService {
    static boolean login(String user, String pass) {
        return user != null && pass != null && user.equals("admin") && pass.equals("1234");
    }
}

public class LoginTest {
    @Test
    void testValidLogin() {
        assertTrue(AuthService.login("admin", "1234"));
    }

    @Test
    void testInvalidLogin() {
        assertFalse(AuthService.login("user", "wrong"));
    }

    @Test
    void testEmptyLogin() {
        assertFalse(AuthService.login("", ""));
    }

    @Test
    void testNullLogin() {
        assertFalse(AuthService.login(null, null));
    }
}

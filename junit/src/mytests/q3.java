package mytests;

public class q3 {

    public static boolean validateLogin(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Sample hardcoded valid credentials
        return username.equals("admin") && password.equals("password123");
    }
}

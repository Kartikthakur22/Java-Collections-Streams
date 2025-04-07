package junit;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
    }
}


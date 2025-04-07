import static org.junit.jupiter.api.Assertions.*;

import junit.UserRegistration;
import org.junit.jupiter.api.*;

public class UserRegistrationTest {

    UserRegistration registration;

    @BeforeEach
    void setUp() {
        registration = new UserRegistration();
    }

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> {
            registration.registerUser("kartik", "kartik@example.com", "secret123");
        });
    }

    @Test
    void testEmptyUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("", "kartik@example.com", "secret123");
        });
    }

    @Test
    void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("kartik", "invalid-email", "secret123");
        });
    }

    @Test
    void testShortPasswordThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("kartik", "kartik@example.com", "123");
        });
    }
}

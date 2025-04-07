import static org.junit.jupiter.api.Assertions.*;

import junit.PasswordValidator;
import org.junit.jupiter.api.*;

public class PasswordValidatorTest {

    PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Strong123"), "Password should be valid");
    }

    @Test
    void testTooShortPassword() {
        assertFalse(validator.isValid("S1hort"), "Password is too short");
    }

    @Test
    void testNoUppercasePassword() {
        assertFalse(validator.isValid("weakpass1"), "Should fail without uppercase letter");
    }

    @Test
    void testNoDigitPassword() {
        assertFalse(validator.isValid("NoDigitsHere"), "Should fail without digit");
    }

    @Test
    void testExactlyEightCharactersValid() {
        assertTrue(validator.isValid("Pass1234"), "Exactly 8 characters, valid password");
    }
}


import junit.IsEven;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsEvenTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testEvenNumbers(int number) {
        IsEven ie=new IsEven();
        assertTrue(ie.isEven(number));
    }
    @ParameterizedTest
    @ValueSource(ints = {7,9})
    void testOddNumbers(int number) {
        IsEven ie=new IsEven();
        assertFalse(ie.isEven(number));
    }
}

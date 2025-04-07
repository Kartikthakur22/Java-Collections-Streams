import junit.ExceptionHandling;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ExceptionHandlingTest {

    @Test
    void testDivide(){
        ExceptionHandling eh=new ExceptionHandling();
        assertThrows(ArithmeticException.class,()->eh.divide(5,0));
    }
}

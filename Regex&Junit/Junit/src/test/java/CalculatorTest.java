import org.testng.annotations.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import junit.Calculator;

public class CalculatorTest {
    public Calculator c1=new Calculator();
    @Test
    void testAdd(){
        assertEquals(5,c1.add(2,3));
    }
    @Test
    void testSubtract(){
        assertEquals(3,c1.subtract(5,2));
    }
    @Test
    void testMultiply(){
        assertEquals(6,c1.multiply(2,3));
    }
    @Test
    void testDivide(){
        assertEquals(3,c1.divide(9,3));
    }
    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class,()->c1.divide(4,0));
    }
}

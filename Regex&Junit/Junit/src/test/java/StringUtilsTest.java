import junit.StringUtils;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {
    StringUtils s1=new StringUtils();
    @Test
    void testReverse(){
        assertEquals("car",s1.reverse("rac"));
    }
    @Test
    void testIsPalindrome(){
        assertTrue(s1.isPalindrome("madam"));
    }
    @Test
    void testConvertToUpper(){
        assertEquals("CAR",s1.convertToUpper("car"));
    }
}

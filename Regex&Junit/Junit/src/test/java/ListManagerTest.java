import junit.ListManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListManagerTest {
    private ListManager lm;
    private List<Integer> list;

    @BeforeEach
    void setUp(){
        lm=new ListManager();
        list=new ArrayList<>();
    }
    @Test
    void testAddElement() {
        lm.addElement(list, 10);
        assertTrue(list.contains(10), "Element should be added to the list");
    }
    void testRemoveElement() {
        lm.addElement(list, 10);
        lm.removeElement(list, 10);
        assertFalse(list.contains(10), "Element should be removed the list");
    }
    @Test
    void testGetSize() {
        lm.addElement(list, 1);
        lm.addElement(list, 2);
        assertEquals(2, lm.getSize(list));
    }
}

import junit.Database;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTest {
    Database db;
    @BeforeEach
    void setUp(){
        db=new Database();
        db.connect();
    }
    @AfterEach
    void close(){
        db.disconnect();
    }
    @Test
    public void testIsConnected(){
        assertTrue(db.isConnected(),"connection is established");
    }
    @Test
    public void testDisconnected(){
        db=new Database();
        db.disconnect();
        assertFalse(db.isConnected(),"connection disconnected");
    }
}

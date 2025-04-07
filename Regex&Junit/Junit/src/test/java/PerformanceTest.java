import junit.Performance;
import org.junit.jupiter.api.Timeout;
import org.testng.annotations.Test;

public class PerformanceTest {
    Performance task = new Performance();

    @Test
    @Timeout(2) // Fails if takes more than 2 seconds
    void testLongRunningTask() {
        task.longRunningTask();
    }
}

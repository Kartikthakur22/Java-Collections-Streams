package junit;

public class Performance {
    public String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            return "Interrupted";
        }
        return "Completed";
    }
}

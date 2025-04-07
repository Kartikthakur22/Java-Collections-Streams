package MethodExecution;
public class TestClass {

    public void methodOne() {
        for (int i = 0; i < 100; i++) {}
    }

    public void methodTwo() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void methodThree() {
        System.out.println("Private method executed.");
    }
}


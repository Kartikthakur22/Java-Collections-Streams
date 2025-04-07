package Annotation.Execution;

import java.lang.reflect.Method;

public class SampleTasks {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 10; i++); // Fast loop
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 100; i++); // Slower loop
    }

    public void regularTask() {
        System.out.println("No logging required here.");
    }
    public static void main(String[] args) throws Exception {
        SampleTasks tasks = new SampleTasks();
        Class<?> clazz = tasks.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();

                method.invoke(tasks);  // Call the annotated method

                long end = System.nanoTime();
                long duration = end - start;

                System.out.println("Executed " + method.getName() +
                    " in " + duration + " ms");
            }
        }
    }
}


package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Define the custom annotation @TaskInfo with fields priority and assignedTo
@Retention(RetentionPolicy.RUNTIME)  // Make it available at runtime
@Target(ElementType.METHOD)  // Apply it to methods
@interface TaskInfo {
    String priority();    // Priority of the task
    String assignedTo();  // Person assigned to the task
}

// TaskManager class where tasks are defined
class TaskManager {
    
    // Apply @TaskInfo annotation to mark the method with task details
    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void task1() {
        System.out.println("Executing task1...");
    }

    @TaskInfo(priority = "Low", assignedTo = "Bob")
    public void task2() {
        System.out.println("Executing task2...");
    }
}

// Class to retrieve and display annotation details using Reflection
public class TaskAnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> clazz = TaskManager.class;
            
            // Get all methods in the TaskManager class
            Method[] methods = clazz.getDeclaredMethods();
            
            // Iterate over each method and check for @TaskInfo annotation
            for (Method method : methods) {
                if (method.isAnnotationPresent(TaskInfo.class)) {
                    // Get the @TaskInfo annotation
                    TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                    
                    // Print the task information
                    System.out.println("Method: " + method.getName());
                    System.out.println("Priority: " + taskInfo.priority());
                    System.out.println("Assigned To: " + taskInfo.assignedTo());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

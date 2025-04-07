package Annotation.ProjectFeatures;

import java.lang.reflect.Method;

import Annotation.ProjectFeatures.TodoFeatures.Todo;

public class Task {
    @Todo(assignedTo = "Kartik", task = "Implement")
    public void frontendPart(){
        System.out.println("Frontend left");
    }
    @Todo(assignedTo = "Abc", task = "Implement")
    public void backendPart(){
        System.out.println("Backend left");
    }
    public static void main(String[] args) {
        Task task=new Task();

        for (Method method : task.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("  Task       : " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority   : " + todo.priority());
                System.out.println("-----------------------------------");
            }
        }
    }
}

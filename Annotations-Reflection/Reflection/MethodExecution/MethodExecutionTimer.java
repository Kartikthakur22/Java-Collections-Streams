package MethodExecution;

import java.lang.reflect.Method;

public class MethodExecutionTimer {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("TestClass");
            Object obj = clazz.getDeclaredConstructor().newInstance();
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getParameterCount() == 0) {
                    method.setAccessible(true);
                    long startTime = System.nanoTime();
                    method.invoke(obj);
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime) / 1_000_000;
                    System.out.println("Executed method: " + method.getName() + " | Time: " + duration + " ms");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


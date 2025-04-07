import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class CalculatorReflection {
    public static void main(String[] args) {
        try {
            Class<?> cls = Calculator.class;
            Object obj = cls.getDeclaredConstructor().newInstance();
            
            // Access and invoke private method 'multiply'
            Method multiplyMethod = cls.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            int result = (int) multiplyMethod.invoke(obj, 5, 10);
            
            System.out.println("Multiplication Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


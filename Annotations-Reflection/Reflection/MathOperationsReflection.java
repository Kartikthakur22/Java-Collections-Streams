import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class MathOperationsReflection {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();
            
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            scanner.close();
            
            // Get the MathOperations class dynamically
            Class<?> cls = MathOperations.class;
            Object obj = cls.getDeclaredConstructor().newInstance();
            
            // Get method dynamically
            Method method = cls.getDeclaredMethod(methodName, int.class, int.class);
            int result = (int) method.invoke(obj, num1, num2);
            
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Invalid method name or error occurred.");
        }
    }
}


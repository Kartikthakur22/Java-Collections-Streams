import java.lang.reflect.*;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class StudentReflection {
    public static void main(String[] args) {
        try {
            // Get the Student class dynamically
            Class<?> cls = Student.class;
            
            // Create an instance without using 'new' keyword
            Constructor<?> constructor = cls.getDeclaredConstructor(String.class);
            Object obj = constructor.newInstance("John Doe");
            
            // Invoke the display method
            Method displayMethod = cls.getDeclaredMethod("display");
            displayMethod.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


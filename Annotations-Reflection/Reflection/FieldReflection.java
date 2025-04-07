import java.lang.reflect.*;
class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}
public class FieldReflection {
    public static void main(String[] args) {
        try {
            Class<?> cls = Person.class;
            
            // Access and modify private field 'age'
            Object obj = cls.getDeclaredConstructor(int.class).newInstance(25);
            Field ageField = cls.getDeclaredField("age");
            ageField.setAccessible(true);
            System.out.println("Original Age: " + ageField.get(obj));
            ageField.set(obj, 30);
            System.out.println("Modified Age: " + ageField.get(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


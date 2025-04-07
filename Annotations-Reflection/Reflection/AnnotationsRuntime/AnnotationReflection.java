package AnnotationsRuntime;

@Author(name = "John Doe")
class MyClass {
    public void display() {
        System.out.println("This is MyClass");
    }
}

public class AnnotationReflection {
    public static void main(String[] args) {
        try {
            // Get the MyClass class dynamically
            Class<?> cls = MyClass.class;
            
            // Check if Author annotation is present
            if (cls.isAnnotationPresent(Author.class)) {
                // Get the Author annotation
                Author author = cls.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No Author annotation present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

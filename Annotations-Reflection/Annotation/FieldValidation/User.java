package Annotation.FieldValidation;

public class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        validate(username);
        this.username = username;
    }

    private void validate(String username) {
        try {
            // Get the field annotated with @MaxLength
            var field = this.getClass().getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds max length of " + maxLength.value());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
    public static void main(String[] args) {
        try {
            User u1 = new User("Kartik"); 
            System.out.println("User 1: " + u1.getUsername());

            User u2 = new User("VeryLongUsername"); 
            System.out.println("User 2: " + u2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}


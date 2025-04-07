package Annotation.RoleBased;

import java.lang.reflect.Method;

public class User {
    private String name;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role.toUpperCase();
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("Deleting user...");
    }

    @RoleAllowed("USER")
    public void viewProfile() {
        System.out.println("Viewing profile...");
    }
    public static void main(String[] args) throws Exception {
        User user = new User("Kartik", "USER");  // Change role here: "ADMIN" or "USER"
        String methodName = "deleteUser";        // Change to "viewProfile" to test

        Method method = User.class.getMethod(methodName);

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            String requiredRole = roleAllowed.value().toUpperCase();

            if (user.getRole().equals(requiredRole)) {
                method.invoke(user);  
            } else {
                System.out.println("Access Denied for " + user.getName() + "! Required role: " + requiredRole);
            }
        } else {
            method.invoke(user); 
        }
    }
}

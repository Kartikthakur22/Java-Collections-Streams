package RepresentJson;

import java.lang.reflect.*;

public class ObjectToJsonRepresentation {

    // Method to convert an object to a JSON-like string using Reflection
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        Class<?> clazz = obj.getClass();
        
        // Start of the JSON object
        json.append("{");
        
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Make the field accessible

            try {
                Object value = field.get(obj); // Get the value of the field
                json.append("\"").append(field.getName()).append("\": ");
                
                // Handle String values with double quotes
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value); // For other types, append the value directly
                }

                // Add comma if not the last field
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // End of the JSON object
        json.append("}");
        
        return json.toString();
    }
    public static void main(String[] args) {
        // Example usage
        Person person = new Person("John", 30, true);
        String jsonRepresentation = toJson(person);
        System.out.println(jsonRepresentation); // Print the JSON-like string
    }
}

package StaticField;
import java.lang.reflect.*;

public class ConfigurationReflection {
    public static void main(String[] args) {
        try {
            // Get the Configuration class dynamically
            Class<?> cls = Configuration.class;
            
            // Access and modify the private static field 'API_KEY'
            Field apiKeyField = cls.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            
            // Print original value
            System.out.println("Original API_KEY: " + apiKeyField.get(null));
            
            // Modify the value of API_KEY
            apiKeyField.set(null, "new_api_key_12345");
            
            // Print modified value
            System.out.println("Modified API_KEY: " + apiKeyField.get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package StaticField;

public class Configuration {
    private static String API_KEY = "initial_api_key";
    public static String getAPIKey() {
        return API_KEY;
    }
}

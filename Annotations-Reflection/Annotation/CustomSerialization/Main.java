public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("kartik123", "kartik@example.com", 22);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
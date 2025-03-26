
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class UsernameValidator {
    public static boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        scanner.close();
        
        System.out.println(username + " → " + (isValidUsername(username) ? "Valid" : "Invalid"));
    }
}


import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class SSNValidator {
    public static boolean isValidSSN(String text) {
        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        scanner.close();
        
        if (isValidSSN(text)) {
            System.out.println("Valid SSN found: " + text);
        } else {
            System.out.println("Invalid SSN format");
        }
    }
}


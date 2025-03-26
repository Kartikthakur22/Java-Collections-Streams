
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class EmailExtractor {
    public static void extractEmails(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted Email Addresses:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        
        extractEmails(text);
    }
}


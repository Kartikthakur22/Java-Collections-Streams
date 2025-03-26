import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class LinkExtractor {
    public static void extractLinks(String text) {
        Pattern pattern = Pattern.compile("https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}[^\s]*");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted Links:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text with links: ");
        String text = scanner.nextLine();
        scanner.close();
        
        extractLinks(text);
    }
}
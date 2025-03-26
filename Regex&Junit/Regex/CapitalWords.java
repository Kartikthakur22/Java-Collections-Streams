import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class CapitalWords {
    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted Capitalized Words:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        scanner.close();
        
        extractCapitalizedWords(text);
    }
}

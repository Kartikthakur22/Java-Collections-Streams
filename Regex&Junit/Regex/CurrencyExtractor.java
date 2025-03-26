import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class CurrencyExtractor {
    public static void extractCurrencyValues(String text) {
        Pattern pattern = Pattern.compile("\\$?\\d+(\\.\\d{2})?");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted Currency Values:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        scanner.close();
        
        extractCurrencyValues(text);
    }
}
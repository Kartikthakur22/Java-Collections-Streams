import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class DateExtractor {
    public static void extractDates(String text) {
        Pattern pattern = Pattern.compile("\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}\\b");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Extracted Dates:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text with dates: ");
        String text = scanner.nextLine();
        scanner.close();
        
        extractDates(text);
    }
}

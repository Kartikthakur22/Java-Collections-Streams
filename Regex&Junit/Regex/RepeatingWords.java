import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;

class RepeatingWords {
    public static void findRepeatingWords(String text) {
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b(?:\\s+\\1\\b)+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        HashSet<String> repeatedWords = new HashSet<>();
        
        System.out.println("Repeating Words:");
        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }
        
        System.out.println(String.join(", ", repeatedWords));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        scanner.close();
        
        findRepeatingWords(text);
    }
}


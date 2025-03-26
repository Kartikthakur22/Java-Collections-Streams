// File: LangExtractor.java
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class LangExtractor {
    public static void extractLanguages(String text) {
        String[] languages = {"Java", "Python", "JavaScript", "C", "C++", "Go", "Ruby", "Swift", "Kotlin", "PHP", "R", "Perl"};
        
        System.out.println("Extracted Programming Languages:");
        for (String lang : languages) {
            Pattern pattern = Pattern.compile("\\b" + lang + "\\b");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                System.out.print(lang + ", ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        scanner.close();
        
        extractLanguages(text);
    }
}

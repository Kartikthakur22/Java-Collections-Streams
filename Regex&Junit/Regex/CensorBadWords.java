import java.util.Scanner;

class CensorBadWords {
    public static String censorText(String text, String[] badWords) {
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        
        String[] badWords = {"damn", "stupid"}; 
        
        System.out.println("Censored Text:");
        System.out.println(censorText(text, badWords));
        
        scanner.close();
    }
}
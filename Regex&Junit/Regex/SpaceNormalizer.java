import java.util.Scanner;

class SpaceNormalizer {
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text with multiple spaces: ");
        String text = scanner.nextLine();
        scanner.close();
        
        System.out.println("Normalized Text:");
        System.out.println(normalizeSpaces(text));
    }
}
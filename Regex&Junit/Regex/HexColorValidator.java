
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        Pattern pattern = Pattern.compile("^#[0-9A-Fa-f]{6}$");
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hex color code: ");
        String color = scanner.nextLine();
        scanner.close();
        
        System.out.println(color + " → " + (isValidHexColor(color) ? "Valid" : "Invalid"));
    }
}


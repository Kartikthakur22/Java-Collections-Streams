
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        Pattern pattern = Pattern.compile("^[A-Z]{2}\\d{4}$");
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();
        scanner.close();
        
        System.out.println(plate + " → " + (isValidLicensePlate(plate) ? "Valid" : "Invalid"));
    }
}


import java.util.Scanner;
import java.util.regex.Pattern;

class ValidateIPAddress {
    public static boolean isValidIPAddress(String ip) {
        String ipPattern = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])"
                + "\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])"
                + "\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])"
                + "\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
        return Pattern.matches(ipPattern, ip);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ip = scanner.nextLine();
        scanner.close();
        
        if (isValidIPAddress(ip)) {
            System.out.println("Valid IP Address");
        } else {
            System.out.println("Invalid IP Address");
        }
    }
}

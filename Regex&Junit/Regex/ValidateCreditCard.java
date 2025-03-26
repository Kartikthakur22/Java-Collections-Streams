import java.util.Scanner;
import java.util.regex.Pattern;

class ValidateCreditCard {
    public static boolean isValidCreditCard(String cardNumber) {
        String visaPattern = "^4[0-9]{15}$";
        String masterCardPattern = "^5[1-5][0-9]{14}$";
        
        return Pattern.matches(visaPattern, cardNumber) || Pattern.matches(masterCardPattern, cardNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        String cardNumber = scanner.nextLine();
        scanner.close();
        
        if (isValidCreditCard(cardNumber)) {
            System.out.println("Valid Credit Card Number");
        } else {
            System.out.println("Invalid Credit Card Number");
        }
    }
}
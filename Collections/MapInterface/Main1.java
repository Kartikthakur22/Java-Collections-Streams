package Collections.MapInterface;

import java.time.LocalDate;

public class Main1 {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new InsurancePolicy("P1001", "John Doe", LocalDate.of(2025, 1, 15)));
        manager.addPolicy(new InsurancePolicy("P1002", "Alice Smith", LocalDate.of(2024, 4, 10)));
        manager.addPolicy(new InsurancePolicy("P1003", "John Doe", LocalDate.of(2024, 3, 30)));
        
        System.out.println("Policy by Number (P1001): " + manager.getPolicyByNumber("P1001"));
        
        System.out.println("\nPolicies expiring within 30 days:");
        for (InsurancePolicy policy : manager.getExpiringPolicies(30)) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies for John Doe:");
        for (InsurancePolicy policy : manager.getPoliciesByHolder("John Doe")) {
            System.out.println(policy);
        }
        
        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();
    }
}
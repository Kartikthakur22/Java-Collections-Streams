package Collections.SetInterface;

import java.time.LocalDate;
import java.util.*;

public class PolicyManagementSystem {

    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    // Add policy to different sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void retrieveAllPolicies() {
        System.out.println("All Policies (HashSet):");
        hashSetPolicies.forEach(System.out::println);
        System.out.println("All Policies (LinkedHashSet):");
        linkedHashSetPolicies.forEach(System.out::println);
        System.out.println("All Policies (TreeSet - Sorted by Expiry Date):");
        treeSetPolicies.forEach(System.out::println);
    }

    // Retrieve policies expiring soon (within the next 30 days)
    public void retrieveExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);

        System.out.println("Policies Expiring Soon (within 30 days):");
        hashSetPolicies.stream()
                .filter(policy -> !policy.getExpiryDate().isBefore(today) && policy.getExpiryDate().isBefore(thirtyDaysLater))
                .forEach(System.out::println);
    }

    // Retrieve policies with a specific coverage type
    public void retrievePoliciesByCoverageType(String coverageType) {
        System.out.println("Policies with coverage type " + coverageType + ":");
        hashSetPolicies.stream()
                .filter(policy -> policy.getCoverageType().equals(coverageType))
                .forEach(System.out::println);
    }

    // Retrieve duplicate policies (based on policy number)
    public void retrieveDuplicatePolicies() {
        Set<String> policyNumbers = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();

        for (Policy policy : hashSetPolicies) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }

        System.out.println("Duplicate Policies (based on policy number):");
        duplicates.forEach(System.out::println);
    }
}


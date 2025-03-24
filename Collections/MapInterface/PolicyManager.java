package Collections.MapInterface;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> sortedByExpiry = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedByExpiry.put(policy.getExpiryDate(), policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getExpiringPolicies(int days) {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(days);
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        
        for (Map.Entry<LocalDate, InsurancePolicy> entry : sortedByExpiry.entrySet()) {
            if (!entry.getKey().isAfter(threshold)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePolicy>> iterator = sortedByExpiry.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                policyMap.remove(entry.getValue().getPolicyNumber());
                orderedPolicyMap.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            }
        }
    }
}


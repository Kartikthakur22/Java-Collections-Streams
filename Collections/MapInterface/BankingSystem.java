package Collections.MapInterface;

import java.util.*;

public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for: " + accountNumber);
        }
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Accounts Sorted by Balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        
        bank.createAccount("A1001", 5000.0);
        bank.createAccount("A1002", 3000.0);
        bank.createAccount("A1003", 7000.0);
        
        bank.deposit("A1001", 2000.0);
        
        bank.requestWithdrawal("A1002");
        bank.requestWithdrawal("A1001");
        
        bank.processWithdrawals();
        bank.displayAccountsSortedByBalance();
    }
}

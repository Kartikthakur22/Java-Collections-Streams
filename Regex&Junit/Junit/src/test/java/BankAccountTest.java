import junit.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }


    @Test
    void testDepositIncreasesBalance() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    void testWithdrawReducesBalance() {
        account.deposit(200.0);
        boolean result = account.withdraw(50.0);
        assertTrue(result, "Withdrawal should succeed");
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdrawFailsIfInsufficientFunds() {
        account.deposit(50.0);
        boolean result = account.withdraw(100.0);
        assertFalse(result, "Withdrawal should fail due to insufficient funds");
        assertEquals(50.0, account.getBalance(), "Balance should remain unchanged");
    }
}

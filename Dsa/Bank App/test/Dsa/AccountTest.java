package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testThatAccountExist() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);
        assertTrue(account.itExist());
    }

    @Test
    public void testThatAccountDoesNotExist() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);
        assertFalse(account.notExist());
    }

    @Test
    public void testDeposit() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        assertEquals(0, account.getBalance());
        account.deposit(200);
        assertEquals(200, account.getBalance());

    }

    @Test
    public void testForNegativeDeposit() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        Exception exception = null;
        try {
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Deposit amount must be greater than 0"));
    }

    @Test
    public void testWithdraw() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        assertEquals(0, account.getBalance());
        account.deposit(200);
        assertEquals(200, account.getBalance());

        account.withdraw(100, pin);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdrawInvalidPin() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        account.deposit(200);

        Exception exception = null;
        try {
            account.withdraw(100, "0000");
        } catch (SecurityException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Invalid PIN"));
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        account.deposit(100);

        Exception exception = null;
        try {
            account.withdraw(200, pin);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Insufficient balance"));
    }

    @Test
    public void testWithdrawNegativeAmount() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        account.deposit(100);

        Exception exception = null;
        try {
            account.withdraw(-100, pin);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Withdrawal amount must be greater than 0"));
    }

    @Test
    public void testWithdrawZeroAmount() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        account.deposit(100);

        Exception exception = null;
        try {
            account.withdraw(0, pin);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception.getMessage().contains("Withdrawal amount must be greater than 0"));
    }

    @Test
    public void testCheckBalance() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        assertEquals(0, account.getBalance());
        account.deposit(200);
        assertEquals(200, account.getBalance());

        assertEquals(200,account.checkBalance(pin));

    }

    @Test
    public void testUpdatePinSuccessfully() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        account.updatePin("1234", "5678");

        account.deposit(200);
        account.withdraw(100, "5678");

        assertEquals(100, account.getBalance());
    }

    @Test
    public void testUpdatePinToSamePin() {
        String pin = "1234";
        String name = "stephen";
        Account account = new Account(pin, name);

        account.updatePin("1234", "1234");

        account.deposit(200);
        account.withdraw(100, "1234");

        assertEquals(100, account.getBalance());
    }

    @Test
        public void testUpdatePinWithIncorrectCurrentPin() {
            String pin = "1234";
            String name = "stephen";
            Account account = new Account(pin, name);

            Exception exception = null;

            try {
                account.updatePin("0000", "5678");
            } catch (SecurityException e) {
                exception = e;
            }

            assertNotNull(exception);
            assertFalse(exception.getMessage().contains("Current PIN is incorrect"));

            account.deposit(200);
            account.withdraw(100, "1234");

            assertEquals(100, account.getBalance(), "Old PIN should still work after failed update");
        }

    }
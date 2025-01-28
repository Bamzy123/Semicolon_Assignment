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
}
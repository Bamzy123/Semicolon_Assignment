package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testForDeposit() {
        Bank bank = new Bank();
        String pin = "1234";
        String name = "stephen";
        bank.createAccount(pin, name);
        bank.deposit(1000, name);
        Account account = bank.findAccount(name);
        assertNotNull(account);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testDepositToNonexistentAccount() {
        Bank bank = new Bank();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.deposit(500, "nonexistentUser");
        });

        assertEquals("Account not found", exception.getMessage());
    }

    @Test
    public void testForWithdraw() {
        Bank bank = new Bank();
        String pin = "1234";
        String name = "stephen";
        bank.createAccount(pin, name);
        bank.deposit(1000,name);
        assertEquals(1000, bank.checkBalance(pin, name));

        bank.withdraw(pin, name, 200);
        assertEquals(800, bank.checkBalance(pin, name));
    }

    @Test
    public void testWithdrawFromNonexistentAccount() {
        Bank bank = new Bank();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw("1234", "nonexistentUser", 200);
        });

        assertEquals("Account not found", exception.getMessage());
    }

    @Test
        public void testWithdrawWithInvalidPin() {
            Bank bank = new Bank();
            String wrongPin = "4321";
            String correctPin = "1234";
            String name = "stephen";

            bank.createAccount(correctPin, name);
            bank.deposit(1000, name);

            Exception exception = assertThrows(SecurityException.class, () -> {
                bank.withdraw(wrongPin, name, 200);
            });

            assertEquals("Invalid PIN", exception.getMessage());
            assertEquals(1000, bank.checkBalance(correctPin, name));
        }

    @Test
    public void testCheckBalanceOfNonexistentAccount() {
        Bank bank = new Bank();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.checkBalance("1234", "nonexistentUser");
        });

        assertEquals("Account not found", exception.getMessage());
    }

    @Test
    public void testWithdrawMoreThanBalance() {
        Bank bank = new Bank();
        String pin = "1234";
        String name = "stephen";

        bank.createAccount(pin, name);
        bank.deposit(1000, name);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw(pin, name, 2000);
        });

        assertEquals("Insufficient balance", exception.getMessage());
        assertEquals(1000, bank.checkBalance(pin,name));
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Bank bank = new Bank();
        String pin = "1234";
        String name = "stephen";

        bank.createAccount(pin, name);
        bank.deposit(1000, name);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw(pin, name, -500);
        });

        assertEquals("Withdrawal amount must be greater than 0", exception.getMessage());
        assertEquals(1000, bank.checkBalance(pin, name));
    }

    @Test
    public void testForTransfer() {
        Bank bank = new Bank();
        String senderPin = "1234";
        String senderName = "stephen";
        String receiverPin = "5678";
        String receiverName = "james";

        bank.createAccount(senderPin, senderName);
        bank.createAccount(receiverPin, receiverName);

        bank.deposit(1000, senderName);
        assertEquals(1000, bank.checkBalance(senderPin, senderName));

        bank.transfer(senderPin, senderName, receiverName, 500);
        assertEquals(500, bank.checkBalance(senderPin, senderName));

        assertEquals(500, bank.checkBalance(receiverPin, receiverName));
    }

    @Test
    public void testTransferWithInvalidPin() {
        Bank bank = new Bank();
        String senderPin = "1234";
        String senderName = "stephen";
        String receiverPin = "5678";
        String receiverName = "james";

        bank.createAccount(senderPin, senderName);
        bank.createAccount(receiverPin, receiverName);
        bank.deposit(1000, senderName);

        Exception exception = assertThrows(SecurityException.class, () -> {
            bank.transfer("0000", senderName, receiverName, 500);
        });

        assertEquals("Invalid PIN", exception.getMessage());
        assertEquals(1000, bank.checkBalance(senderPin, senderName));
        assertEquals(0, bank.checkBalance(receiverPin, receiverName));
    }

    @Test
    public void testTransferWithInsufficientFunds() {
        Bank bank = new Bank();
        String senderPin = "1234";
        String senderName = "stephen";
        String receiverPin = "5678";
        String receiverName = "james";

        bank.createAccount(senderPin, senderName);
        bank.createAccount(receiverPin, receiverName);
        bank.deposit(1000, senderName);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.transfer(senderPin, senderName, receiverName, 1500);
        });

        assertEquals("Insufficient balance", exception.getMessage());

        assertEquals(1000, bank.checkBalance(senderPin, senderName));
        assertEquals(0, bank.checkBalance(receiverPin, receiverName));
    }

    @Test
    public void testTransferNegativeAmount() {
        Bank bank = new Bank();
        String senderPin = "1234";
        String senderName = "stephen";
        String receiverPin = "5678";
        String receiverName = "james";

        bank.createAccount(senderPin, senderName);
        bank.createAccount(receiverPin, receiverName);
        bank.deposit(1000, senderName);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bank.transfer(senderPin, senderName, receiverName, -100);
        });

        assertEquals("Transfer amount must be greater than 0", exception.getMessage());

        assertEquals(1000, bank.checkBalance(senderPin, senderName));
        assertEquals(0, bank.checkBalance(receiverPin, receiverName));
    }

    @Test
    public void testCloseAccount() {
        Bank bank = new Bank();
        String pin = "1234";
        String name = "stephen";

        bank.createAccount(pin, name);
        bank.deposit(1000, name);

        assertNotNull(bank.findAccount(name));

        bank.closeAccount(pin, name);

        assertNull(bank.findAccount(name));
    }
}
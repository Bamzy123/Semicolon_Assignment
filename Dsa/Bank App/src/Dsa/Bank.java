package Dsa;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    public Bank() {
        this.accounts = new ArrayList<>();
    }
    public void createAccount(String pin, String name) {
        accounts.add(new Account(pin, name));
    }

    public Account findAccount(String name) {
        for (Account account : accounts) {
            if (account.getName().equals(name));
            return account;
        }
        return null;
    }

    public void deposit(int amount, String name) {
        Account account = findAccount(name);
        if (account != null) account.deposit(amount);
        else throw new IllegalArgumentException("Account not found");
    }

    public int checkBalance(String pin, String name) {
        Account account = findAccount(name);
        if (account != null) return account.checkBalance(pin);
        else throw new IllegalArgumentException("Account not found");
    }

    public void withdraw(String pin, String name, int amount) {
        Account account = findAccount(name);
        if (account != null) account.withdraw(amount, pin);
        else throw new IllegalArgumentException("Account not found");
    }

    public void transfer(String senderPin, String senderName, String receiverName, int amount) {
        Account sender = findAccount(senderName);
        Account receiver = findAccount(receiverName);

        if (!sender.validatePin(senderPin)) throw new SecurityException("Invalid PIN");

        if (sender.getBalance() < amount) throw new IllegalArgumentException("Insufficient balance");

        sender.withdraw(amount, senderPin);
        receiver.deposit(amount);
    }
}
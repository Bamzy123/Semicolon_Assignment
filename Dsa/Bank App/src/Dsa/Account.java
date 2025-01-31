package Dsa;

public class Account {
    private int balance;
    private boolean itExist;
    private String pin;
    private String name;

    public Account(String pin, String name) {
        this.balance = 0;
        this.itExist = true;
        this.pin = pin;
        this.name = name;
    }

    public boolean itExist()
    {
        return itExist;
    }
    public boolean notExist() {
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) balance += amount;
        else throw new IllegalArgumentException("Deposit amount must be greater than 0");
    }

    public void withdraw(int amount, String inputPin) {
        if (!inputPin.equals(pin)) throw new SecurityException("Invalid PIN");
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }

    public int checkBalance(String inputPin) {
        if (!this.pin.equals(inputPin)) throw new SecurityException("Invalid PIN");
        return balance;
    }

    public void updatePin(String oldPin, String newPin) {
        if (!this.pin.equals(oldPin)) throw new SecurityException("Invalid PIN");
        if (newPin == null || newPin.length() != 4)
            throw new IllegalArgumentException("New pin must be exactly 4 digits");
        this.pin = newPin;
    }

    public String getName() {
        return name;
    }

    public boolean validatePin(String senderPin) {
        return !this.pin.equals(senderPin);
    }
}
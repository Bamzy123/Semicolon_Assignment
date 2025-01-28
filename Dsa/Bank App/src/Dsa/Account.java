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
        itExist = false;
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
        if (!inputPin.equals(pin)) {
            throw new SecurityException("Invalid PIN");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public int checkBalance(String inputPin) {
        if (inputPin.equals(pin)) {
            return balance;
        } else {
            throw new SecurityException("Invalid PIN");
        }
    }

    public void updatePin(String oldPin, String newPin) {
        if (!oldPin.equals(pin)) {
            throw new SecurityException("Invalid PIN");
        }
        pin = newPin;
    }
}

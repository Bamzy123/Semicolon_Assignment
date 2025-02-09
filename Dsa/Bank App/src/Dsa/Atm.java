package Dsa;

import java.util.Scanner;

public class Atm {
    private static final Bank bank = new Bank();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        do {
            displayMenu();
            int choice = getUserChoice();
            executeChoice(choice);
        } while (true);
    }

    private static void displayMenu() {
        System.out.println("\n---- Bank System Main Menu ----");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Check Balance");
        System.out.println("6. Close Account");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 7) return choice;
                System.out.println("Invalid choice. Please select a number between 1 and 7.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void executeChoice(int choice) {
        switch (choice) {
            case 1 -> createAccount();
            case 2 -> deposit();
            case 3 -> withdraw();
            case 4 -> transfer();
            case 5 -> checkBalance();
            case 6 -> closeAccount();
            case 7 -> {
                System.out.println("Exiting system. Goodbye!");
                System.exit(0);
            }
            default ->
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        bank.createAccount(pin, name);
        System.out.println("Account created successfully for " + name + "!");
    }

    private static void deposit() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        bank.deposit(amount, name);
        System.out.println("Deposit successful! New balance: " + bank.checkBalance(pin, name));
    }

    private static void withdraw() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        try {
            bank.withdraw(pin, name, amount);
            System.out.println("Withdrawal successful! New balance: " + bank.checkBalance(pin, name));
        } catch (IllegalArgumentException | SecurityException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void transfer() {
        System.out.print("Enter sender's name: ");
        String senderName = scanner.nextLine();
        System.out.print("Enter sender's PIN: ");
        String senderPin = scanner.nextLine();
        System.out.print("Enter receiver's name: ");
        String receiverName = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        try {
            bank.transfer(senderPin, senderName, receiverName, amount);
            System.out.println("Transfer successful!");
            System.out.println("New balance for " + senderName + ": " + bank.checkBalance(senderPin, senderName));
            System.out.println("Enter receiver's pin: ");
            String receiverPin = scanner.nextLine();
            System.out.println("New balance for " + receiverName + ": " + bank.checkBalance(receiverPin, receiverName));
        } catch (IllegalArgumentException | SecurityException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        System.out.println("Current balance: " + bank.checkBalance(pin, name));
    }

    private static void closeAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        try {
            bank.closeAccount(pin, name);
            System.out.println("Account closed successfully!");
        } catch (IllegalArgumentException | SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}
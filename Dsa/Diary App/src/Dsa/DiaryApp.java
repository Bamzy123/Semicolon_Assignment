package Dsa;

import javax.swing.JOptionPane;

public class DiaryApp {
    public static void main(String... args) {
        String userName = JOptionPane.showInputDialog("Enter your name");
        if (userName == null || userName.isBlank()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty");
        }

        String password = JOptionPane.showInputDialog("Enter your password");
        if (password == null || password.isBlank()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty");
        }

        Diary diary = new Diary(userName, password);

        String inputPassword = JOptionPane.showInputDialog("Enter the password to unlock your diary:");
        diary.unlockDiary(inputPassword);

        if (diary.isLocked()) {
            JOptionPane.showMessageDialog(null, "Incorrect password. Exiting application.");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null, "Diary unlocked successfully!");

        String menu = "Select an option:\n"
                + "1. Create a new entry\n"
                + "2. Update an existing entry\n"
                + "3. Delete an entry\n"
                + "4. View an entry\n"
                + "5. Exit";

        while (true) {
            String choice = JOptionPane.showInputDialog(menu);
            if (choice == null) break;

            switch (choice) {
                case "1" -> {
                    String title = JOptionPane.showInputDialog("Enter entry title:");
                    String body = JOptionPane.showInputDialog("Enter entry body:");
                    try {
                        diary.createEntry(title, body);
                        JOptionPane.showMessageDialog(null, "Entry created successfully.");
                    } catch (IllegalStateException | IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                }
                case "2" -> {
                    try {
                        String updateIdStr = JOptionPane.showInputDialog("Enter the ID of the entry to update:");
                        int updateId = Integer.parseInt(updateIdStr);
                        String newTitle = JOptionPane.showInputDialog("Enter new title:");
                        String newBody = JOptionPane.showInputDialog("Enter new body:");
                        diary.updateEntry(updateId, newTitle, newBody);
                        JOptionPane.showMessageDialog(null, "Entry updated successfully.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                }
                case "3" -> {
                    try {
                        String deleteIdStr = JOptionPane.showInputDialog("Enter the ID of the entry to delete:");
                        int deleteId = Integer.parseInt(deleteIdStr);
                        diary.deleteEntry(deleteId);
                        JOptionPane.showMessageDialog(null, "Entry deleted (if it existed).");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                }
                case "4" -> {
                    try {
                        String viewIdStr = JOptionPane.showInputDialog("Enter the ID of the entry to view:");
                        int viewId = Integer.parseInt(viewIdStr);
                        Entry entry = diary.findEntryById(viewId);
                        if (entry != null) {
                            String details = "ID: " + entry.getId() + "\n"
                                    + "Title: " + entry.getTitle() + "\n"
                                    + "Body: " + entry.getBody() + "\n"
                                    + "Created On: " + entry.getDateCreated();
                            JOptionPane.showMessageDialog(null, details);
                        } else {
                            JOptionPane.showMessageDialog(null, "No entry found with that ID.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                }
                case "5" -> {
                    JOptionPane.showMessageDialog(null, "Exiting the Diary App. Goodbye!");
                    System.exit(0);
                }
                default ->
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
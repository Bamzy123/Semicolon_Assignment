package Dsa;

import javax.swing.JOptionPane;

public class DiaryApp {

    private static Diary diary;

    public static void main(String... args) {
        initializeDiary();
        showMenu();
    }

    private static void initializeDiary() {
        String userName = JOptionPane.showInputDialog("Enter your name:");
        if (userName == null || userName.isBlank()) {
            showMessageAndExit("Name cannot be empty. Exiting application.");
        }

        String password = JOptionPane.showInputDialog("Enter your password:");
        if (password == null || password.isBlank()) {
            showMessageAndExit("Password cannot be empty. Exiting application.");
        }

        diary = new Diary(userName, password);
        diary.unlockDiary(password);

        if (diary.isLocked()) {
            showMessageAndExit("Unable to unlock your diary. Exiting application.");
        }

        JOptionPane.showMessageDialog(null, "Diary unlocked successfully!");
    }

    private static void showMenu() {
        String menu = """
                Select an option:
                1. Create a new entry
                2. Update an existing entry
                3. Delete an entry
                4. View an entry
                5. Lock diary
                6. Unlock diary
                7. Exit""";

        while (true) {
            String choice = JOptionPane.showInputDialog(menu);
            if (choice == null) break;

            switch (choice) {
                case "1" -> handleCreateEntry();
                case "2" -> handleUpdateEntry();
                case "3" -> handleDeleteEntry();
                case "4" -> handleViewEntry();
                case "5" -> handleLockDiary();
                case "6" -> handleUnlockDiary();
                case "7" -> {
                    JOptionPane.showMessageDialog(null, "Exiting the Diary App, Goodbye!");
                    System.exit(0);
                }
                default ->
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

    private static void handleCreateEntry() {
        String title = JOptionPane.showInputDialog("Enter entry title:");
        if (title == null || title.isBlank()) {
            JOptionPane.showMessageDialog(null, "Title cannot be empty.");
            return;
        }

        Entry existingEntry = diary.findEntryByTitle(title);
        if (existingEntry != null) {
            String details = "An entry with that title already exists:\n" +
                    "ID: " + existingEntry.getId() + "\n" +
                    "Title: " + existingEntry.getTitle() + "\n" +
                    "Body: " + existingEntry.getBody() + "\n" +
                    "Created On: " + existingEntry.getDateCreated();
            JOptionPane.showMessageDialog(null, details);
            return;
        }

        String body = JOptionPane.showInputDialog("Enter entry body:");
        if (body == null || body.isBlank()) {
            JOptionPane.showMessageDialog(null, "Body cannot be empty.");
            return;
        }

        try {
            diary.createEntry(title, body);
            JOptionPane.showMessageDialog(null, "Entry created successfully.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void handleUpdateEntry() {
        try {
            String updateIdStr = JOptionPane.showInputDialog("Enter the ID of the entry to update:");
            if (updateIdStr == null) return;
            int updateId = Integer.parseInt(updateIdStr);
            String newTitle = JOptionPane.showInputDialog("Enter new title:");
            String newBody = JOptionPane.showInputDialog("Enter new body:");
            diary.updateEntry(updateId, newTitle, newBody);
            JOptionPane.showMessageDialog(null, "Entry updated successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void handleDeleteEntry() {
        try {
            String deleteIdStr = JOptionPane.showInputDialog("Enter the ID of the entry to delete:");
            if (deleteIdStr == null) return;
            int deleteId = Integer.parseInt(deleteIdStr);
            diary.deleteEntry(deleteId);
            JOptionPane.showMessageDialog(null, "Entry deleted successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void handleViewEntry() {
        String searchOption = JOptionPane.showInputDialog("Search entry by:\n1. ID\n2. Title");
        if (searchOption == null) return;

        if (searchOption.equals("1")) {
            try {
                String viewIdStr = JOptionPane.showInputDialog("Enter the ID of the entry to view:");
                if (viewIdStr == null) return;
                int viewId = Integer.parseInt(viewIdStr);
                Entry entry = diary.findEntryById(viewId);
                if (entry != null) {
                    showEntryDetails(entry);
                } else {
                    JOptionPane.showMessageDialog(null, "No entry found with that ID.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (searchOption.equals("2")) {
            String title = JOptionPane.showInputDialog("Enter the title of the entry to view:");
            if (title == null || title.isBlank()) return;
            Entry entry = diary.findEntryByTitle(title);
            if (entry != null) {
                showEntryDetails(entry);
            } else {
                JOptionPane.showMessageDialog(null, "No entry found with that title.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid option.");
        }
    }

    private static void showEntryDetails(Entry entry) {
        String details = "ID: " + entry.getId() + "\n" +
                "Title: " + entry.getTitle() + "\n" +
                "Body: " + entry.getBody() + "\n" +
                "Created On: " + entry.getDateCreated();
        JOptionPane.showMessageDialog(null, details);
    }

    private static void handleLockDiary() {
        diary.lockDiary();
        JOptionPane.showMessageDialog(null, "Diary has been locked.");
    }

    private static void handleUnlockDiary() {
        String unlockPass = JOptionPane.showInputDialog("Enter the password to unlock your diary:");
        diary.unlockDiary(unlockPass);
        if (diary.isLocked())
            JOptionPane.showMessageDialog(null, "Incorrect password. Diary remains locked.");
        else
            JOptionPane.showMessageDialog(null, "Diary unlocked successfully!");
    }

    private static void showMessageAndExit(String message) {
        JOptionPane.showMessageDialog(null, message);
        System.exit(0);
    }
}

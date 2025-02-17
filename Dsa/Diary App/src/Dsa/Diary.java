package Dsa;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;

public class Diary implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String userName;
    private final String password;
    private boolean locked;
    private List<Entry> entries;
    private int nextId;

    private final transient File diaryFile;

    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.locked = true;
        this.entries = new ArrayList<>();
        this.nextId = 1;
        this.diaryFile = new File("diary_" + userName + ".dat");
        loadDiary();
    }

    public boolean isLocked() {
        return locked;
    }

    public void lockDiary() {
        locked = true;
        saveDiary();
    }

    public void unlockDiary(String password) {
        if (this.password.equals(password)) {
            locked = false;
        }
    }

    public void createEntry(String title, String body) {
        if (locked) {
            throw new IllegalStateException("Diary is locked. Unlock it first.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        if (body == null || body.isBlank()) {
            throw new IllegalArgumentException("Body cannot be empty.");
        }

        if (findEntryByTitle(title) != null) {
            throw new IllegalArgumentException("An entry with that title already exists.");
        }
        Entry newEntry = new Entry(nextId++, title, body, LocalDateTime.now());
        entries.add(newEntry);
        saveDiary();
    }

    public void updateEntry(int id, String newTitle, String newBody) {
        if (locked) {
            throw new IllegalStateException("Diary is locked. Unlock it first.");
        }
        Entry entry = findEntryById(id);
        if (entry == null) {
            throw new IllegalArgumentException("Entry with ID " + id + " not found.");
        }
        entry.setTitle(newTitle);
        entry.setBody(newBody);
        saveDiary();
    }

    public void deleteEntry(int id) {
        if (locked) {
            throw new IllegalStateException("Diary is locked. Unlock it first.");
        }
        Entry entry = findEntryById(id);
        if (entry == null) {
            throw new IllegalArgumentException("Entry with ID " + id + " not found.");
        }
        entries.remove(entry);
        saveDiary();
    }

    public Entry findEntryById(int id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    public Entry findEntryByTitle(String title) {
        for (Entry entry : entries) {
            if (entry.getTitle().equalsIgnoreCase(title)) {
                return entry;
            }
        }
        return null;
    }

    private void loadDiary() {
        if (!diaryFile.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(diaryFile))) {
            Diary loadedDiary = (Diary) ois.readObject();
            this.entries = loadedDiary.entries;
            this.nextId = loadedDiary.nextId;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading diary: " + e.getMessage());
        }
    }

    private void saveDiary() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(diaryFile))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error saving diary: " + e.getMessage());
        }
    }

    public String getUserName() {
        return userName;
    }
}

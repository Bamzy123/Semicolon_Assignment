package Dsa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Diary {
    private final String userName;
    private final String password;
    private boolean isLocked;
    private final List<Entry> entries;

    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.isLocked = true;
        this.entries = new ArrayList<>();
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlockDiary(String inputPassword) {
        if (this.password.equals(inputPassword)) this.isLocked = false;
    }

    public void lockDiary() {
        this.isLocked = true;
    }

    public void createEntry(String title, String body) {
        if (isLocked) throw new IllegalStateException("Diary is locked! Unlock it to create an entry.");
        if (title.isBlank() || body.isBlank()) throw new IllegalArgumentException("Title and body cannot be empty.");
        int newId = entries.size() + 1;
        Entry entry = new Entry(newId, title, body);
        entries.add(entry);
    }

    public Entry findEntryById(int id) {
        for (Entry entry : entries) if (entry.getId() == id) return entry;
        return null;
    }

    public void updateEntry(int id, String newTitle, String newBody) {
        Entry entry = findEntryById(id);
        if (entry == null) throw new IllegalArgumentException("Entry with ID " + id + " not found.");
        entry.setTitle(newTitle);
        entry.setBody(newBody);
        entry.setDateCreated(LocalDateTime.now());
    }

    public void deleteEntry(int id) {
        entries.removeIf(entry -> entry.getId() == id);
    }

    public String getUserName() {
        return userName;
    }
}

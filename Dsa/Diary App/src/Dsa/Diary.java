package Dsa;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String userName;
    private String password;
    private boolean isLocked;
    private List<Entry> entries;

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
        if (isLocked) {
            throw new IllegalStateException("Diary is locked! Unlock it to create an entry.");
        }

        if (title.isBlank() || body.isBlank()) {
            throw new IllegalArgumentException("Title and body cannot be empty.");
        }

         int newId = entries.size() + 1;
         Entry entry = new Entry(newId, title, body);
          entries.add(entry);
    }

}

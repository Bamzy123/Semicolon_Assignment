package Dsa;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String userName;
    private String password;
    private boolean isLocked;
    private List<Entry> diary;

    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.isLocked = true;
        this.diary = new ArrayList<>();
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlockDiary(String inputPassword) {
        if (this.password.equals(inputPassword)) this.isLocked = false;
    }
}

package Dsa;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private final List<Diary> diaries;

    public Diaries() {
        this.diaries = new ArrayList<>();
    }

    public void addDiary(Diary diary) {
        diaries.add(diary);
    }

    public Diary findDiaryByUsername(String userName) {
        for (Diary diary : diaries) {
            if (diary.getUserName().equals(userName)) {
                return diary;
            }
        }
        return null;
    }

    public void deleteDiary(String userName) {
        diaries.removeIf(diary -> diary.getUserName().equals(userName));
    }
}
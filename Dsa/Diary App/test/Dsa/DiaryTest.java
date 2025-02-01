package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    @Test
    public void testDiaryCanBeCreated() {
        Diary diary = new Diary("stephen", "password123");
        assertNotNull(diary);
    }

    @Test
    public void testThatDiaryIsLocked() {
        Diary diary = new Diary("stephen", "password123");
        assertTrue(diary.isLocked());
    }

    @Test
    void testDiaryCanBeUnlockedWithCorrectPassword() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");
        assertFalse(diary.isLocked());
    }

    @Test

}

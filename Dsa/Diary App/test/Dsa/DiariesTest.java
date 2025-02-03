package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {

    @Test
    public void testCanAddAndFindDiary() {
        Diaries diaries = new Diaries();

        Diary diary1 = new Diary("Sam", "passSam");
        Diary diary2 = new Diary("Divine", "passDivine");

        diaries.addDiary(diary1);
        diaries.addDiary(diary2);

        Diary foundSamDiary = diaries.findDiaryByUsername("Sam");
        Diary foundDivineDiary = diaries.findDiaryByUsername("Divine");

        assertNotNull(foundSamDiary, "Diary for Sam should be found.");
        assertNotNull(foundDivineDiary, "Diary for Divine should be found.");
        assertEquals("Sam", foundSamDiary.getUserName());
        assertEquals("Divine", foundDivineDiary.getUserName());
    }

    @Test
    public void testFindingNonExistentDiaryReturnsNull() {
        Diaries diaries = new Diaries();
        Diary diary1 = new Diary("Sam", "passSam");
        diaries.addDiary(diary1);

        assertNull(diaries.findDiaryByUsername("Esther"), "Should return null for a non-existent diary.");
    }

    @Test
    public void testCanDeleteDiary() {
        Diaries diaries = new Diaries();

        Diary diary1 = new Diary("Sam", "passSam");
        Diary diary2 = new Diary("Divine", "passDivine");
        diaries.addDiary(diary1);
        diaries.addDiary(diary2);

        diaries.deleteDiary("Sam");

        assertNull(diaries.findDiaryByUsername("Sam"), "Divine's diary should be deleted.");

        assertNotNull(diaries.findDiaryByUsername("Divine"), "Sam's diary should still be present.");
    }
}
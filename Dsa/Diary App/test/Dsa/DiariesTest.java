package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {

    @Test
    public void testCanAddAndFindDiary() {
        Diaries diaries = new Diaries();

        Diary diary1 = new Diary("Alice", "passAlice");
        Diary diary2 = new Diary("Bob", "passBob");

        diaries.addDiary(diary1);
        diaries.addDiary(diary2);

        Diary foundAliceDiary = diaries.findDiaryByUsername("Alice");
        Diary foundBobDiary = diaries.findDiaryByUsername("Bob");

        assertNotNull(foundAliceDiary, "Diary for Alice should be found.");
        assertNotNull(foundBobDiary, "Diary for Bob should be found.");
        assertEquals("Alice", foundAliceDiary.getUserName());
        assertEquals("Bob", foundBobDiary.getUserName());
    }

    @Test
    public void testFindingNonExistentDiaryReturnsNull() {
        Diaries diaries = new Diaries();
        Diary diary1 = new Diary("Alice", "passAlice");
        diaries.addDiary(diary1);

        assertNull(diaries.findDiaryByUsername("Charlie"), "Should return null for a non-existent diary.");
    }

    @Test
    public void testCanDeleteDiary() {
        Diaries diaries = new Diaries();

        Diary diary1 = new Diary("Alice", "passAlice");
        Diary diary2 = new Diary("Bob", "passBob");
        diaries.addDiary(diary1);
        diaries.addDiary(diary2);

        diaries.deleteDiary("Alice");

        assertNull(diaries.findDiaryByUsername("Alice"), "Alice's diary should be deleted.");

        assertNotNull(diaries.findDiaryByUsername("Bob"), "Bob's diary should still be present.");
    }
}
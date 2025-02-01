package Dsa;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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
    public void testDiaryCanBeUnlockedWithCorrectPassword() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");
        assertFalse(diary.isLocked());
    }

    @Test
    public void testDiaryCanBeLocked() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void testDiaryCannotCreateEntryWhenLocked() {
        Diary diary = new Diary("Bamsy", "password123");
        assertThrows(IllegalStateException.class, () -> diary.createEntry("My Secret", "This is a private note"));
    }

    @Test
    public void testDiaryCanCreateEntryWhenUnlocked() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");
        assertDoesNotThrow(() -> diary.createEntry("My Day", "It was amazing!"));
    }

    @Test
    public void testDiaryCannotCreateEntryWithEmptyTitleOrBody() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");

        assertThrows(IllegalArgumentException.class, () -> diary.createEntry("", "This is a test"));
        assertThrows(IllegalArgumentException.class, () -> diary.createEntry("Title", ""));
    }

    @Test
    public void testCanFindEntryById() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");

        diary.createEntry("My First Entry", "This is my first diary entry.");
        diary.createEntry("Second Entry", "Another entry in my diary.");

        Entry foundEntry = diary.findEntryById(1);
        assertNotNull(foundEntry);
        assertEquals("My First Entry", foundEntry.getTitle());
    }

    @Test
    public void testFindingNonExistentEntryReturnsNull() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");

        assertNull(diary.findEntryById(99));
    }

    @Test
    public void testCanUpdateEntry() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");

        diary.createEntry("Old Title", "Old Body");
        diary.updateEntry(1, "New Title", "New Body");

        Entry updatedEntry = diary.findEntryById(1);
        assertEquals("New Title", updatedEntry.getTitle());
        assertEquals("New Body", updatedEntry.getBody());
    }

    @Test
    public void testUpdatingNonExistentEntryThrowsException() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");

        assertThrows(IllegalArgumentException.class, () -> diary.updateEntry(99, "New Title", "New Body"));
    }

    @Test
    public void testCanDeleteEntry() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");

        diary.createEntry("Title", "Body");
        diary.deleteEntry(1);

        assertNull(diary.findEntryById(1));
    }

    @Test
    public void testDeletingNonExistentEntryDoesNothing() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");

        assertDoesNotThrow(() -> diary.deleteEntry(99)); // Should not throw an exception
    }

    @Test
    public void testUpdatingEntryChangesTimestamp() {
        Diary diary = new Diary("Bamsy", "password123");
        diary.unlockDiary("password123");

        diary.createEntry("Old Title", "Old Body");
        Entry entry = diary.findEntryById(1);
        LocalDateTime oldTimestamp = entry.getDateCreated();

        // Wait a bit to ensure timestamp change is noticeable
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        diary.updateEntry(1, "New Title", "New Body");
        LocalDateTime newTimestamp = entry.getDateCreated();

        assertTrue(newTimestamp.isAfter(oldTimestamp));
    }
}

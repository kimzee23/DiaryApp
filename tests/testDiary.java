import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class testDiary {
    @Test
    public void testGetUsername() {
        Diary diary =  new Diary("username","password");
        String expectedUserName = "username";
        String actualUserName = diary.getUserName();
        assertEquals(expectedUserName,actualUserName,"User name returns correct user name");
    }
    @Test
    public void testSetUsername() {
        Diary diary =  new Diary("username","password");
        diary.setUsername("new username");
        String actualUserName = diary.getUserName();
        String expectedUserName = "new username";
        assertEquals(actualUserName,expectedUserName,"User name set correct  new username");
    }
    @Test
    public void testSetUsernameValidation() {
        Diary diary =  new Diary("username","password");
        assertThrows(IllegalArgumentException.class, () -> {
            diary.setUsername("");
        });
    }
    @Test
    public void testGetPassword() {
        Diary diary =  new Diary("username","password");
        String expectedPassword = "password";
        String actualPassword = diary.getPassword();
        assertEquals(expectedPassword,actualPassword,"Password returns correct password value");
    }
    @Test
    public  void testSetPassword() {
        Diary diary =  new Diary("username","password");
        diary.setPassword("1234pass");
        String actualPassword = diary.getPassword();
        String expectedPassword = "1234pass";
        assertEquals(actualPassword,expectedPassword,"Password returns correct password value");
    }
    @Test
    public void testSetPasswordValidation() {
        Diary diary =  new Diary("username","password");
        assertThrows(IllegalArgumentException.class, () -> {
            diary.setPassword("");
        });
    }
    @Test
    public void testIsLocked() {
        Diary diary =  new Diary("username","password");
        assertTrue(diary.isLocked(),"The dairy is locked");

        diary.lockDiary();
        assertTrue(diary.isLocked(),"The dairy is locked");

        diary.unLockDiary();
        assertFalse(diary.isLocked(),"The dairy is Unlocked");
    }
    @Test
    public void testAddEntry() {
        Diary diary =  new Diary("username","password");
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        diary.addEntry(diaryEntry);
        List<Entry> inputs = diary.getInputs();


        assertEquals(1, inputs.size(),"There should be one entry");
        assertEquals("A new day",inputs.get(0).getTitle());
    }
    @Test
    public void testGetEntryIfIsEmpty() {
        Diary diary =  new Diary("username","password");
        assertTrue(diary.getInputs().isEmpty());
    }
        @Test
        public  void testFindEntryById() {
            Diary diary = new Diary("username","password");
            Entry diaryEntry = new Entry(2300322,"A new day","Got a job","2025-02-02");
            Entry diaryEntryTwo = new Entry(550022,"new title","what a day ","2025-02-04");
            diary.addEntry(diaryEntry);
            diary.addEntry(diaryEntryTwo);
            Entry  entryIdFound = diary.findEntryById(550022);

            assertEquals("new title",entryIdFound.getTitle());

        }
        @Test
    public  void testFindEntryByTitle() {
        Diary diary = new Diary("username","password");
        Entry result = diary.findEntryById(555);
        assertNull(result);
        }

    @Test
    public void testViewAllDiaries() {
        Diary diary = new Diary("username","password");
        Entry diaryEntry = new Entry(21002,"new title","my text body","2025-4-21");
        Entry diaryEntryTwo = new Entry(21003,"the new title","the text body","2025-4-22");
        diary.addEntry(diaryEntry);
        diary.addEntry(diaryEntryTwo);
        List<Entry> allInput = diary.getInputs();

        assertEquals(21002,allInput.size(),"return all inputs");
        assertEquals("new title",allInput.get(0).getTitle(),"return title");
        assertEquals("the new title",allInput.get(1).getTitle(),"return title if it matches");

    }
    @Test
    public void testEditDiaryWithId() {
        Diary diary = new Diary("username","password");
        Entry diaryEntry = new Entry(21002,"old title"," old body","2025-4-21");
        diary.addEntry(diaryEntry);
        diary.editEntry(20212,"new title","new boy");
        Entry updateEntry = diary.findEntryById(20212);
        assertEquals("new title",updateEntry.getTitle(),"return title");
        assertEquals("new body",updateEntry.getBody(),"return body");
    }
    @Test
    public void testDeleteDiary() {
        Diary diary = new Diary("username","password");
        Entry diaryEntryOne = new Entry(21002,"the title"," old body","2025-4-21");
        Entry diaryEntry = new Entry(21003,"the titles","the bodys","2025-04-22");
        diary.addEntry(diaryEntryOne);
        diary.addEntry(diaryEntry);
        diary.deleteEntry(21002);
        Entry deleteEntry = diary.findEntryById(1);
        assertNull(deleteEntry,"Deleted entry wtih the id 21003");
        assertNotNull(diary.findEntryById(21003),"id with 21003 is still available");

    }

}

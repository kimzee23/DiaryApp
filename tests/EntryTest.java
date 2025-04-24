import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class EntryTest {

    @Test
    public void testGetId() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        int actualId = diaryEntry.getId();
        assertEquals(2300322,actualId,"ID returns correct ID address");

    }

    @Test
    public void testGetIdIsNotCorrect() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        int actualId = diaryEntry.getId();
        assertNotEquals(90999000,actualId,"ID returns correct ID address");
    }

    @Test
    public void testGetTitle() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        String expectedTitle = "A new day";
        String actualTitle = diaryEntry.getTitle();
        assertEquals(expectedTitle,actualTitle,"Titles returns correct title");
    }
    @Test
    public void testGetTitleIsAlsoCorrect() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        String expectedTitle = "12340-";
        String actualTitle = diaryEntry.getTitle();
        assertEquals(expectedTitle,actualTitle,"Titles returns correct title");

    }

    @Test
    public void testSetTitle() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        diaryEntry.setTitle("this day was not a lot again");
        String actualTitle = diaryEntry.getTitle();
        String expectedTitle = "this day was not a lot again";
        assertEquals(expectedTitle,actualTitle,"Titles returns correct title");
    }
    @Test
    public void testSetTitleValidation() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        assertThrows(IllegalArgumentException.class, () -> {
            diaryEntry.setTitle("");
        });
    }

    @Test
    public void testGetBody() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");        String expectedBody = "Got a job";
        String actualBody = diaryEntry.getBody();
        assertEquals(expectedBody,actualBody,"Body returns correct body value");
    }
    @Test
    public void testSetBody() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        diaryEntry.setBody("changing story");
        String actualBody = diaryEntry.getBody();
        String expectedBody = "changing story";
        assertEquals(expectedBody,actualBody,"Body returns correct body value");
    }
    @Test
    public void testSetBodyValidation() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");
        assertThrows(IllegalArgumentException.class, () -> {
            diaryEntry.setBody("");
        });
    }
    @Test
    public void testDateCreated() {
        Entry diaryEntry =  new Entry(2300322,"A new day","Got a job","2025-02-02");

        LocalDate expectedDate = LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth());
        assertEquals(expectedDate, diaryEntry.getDateCreated(), "The dateCreated should match the input date.");
    }

}
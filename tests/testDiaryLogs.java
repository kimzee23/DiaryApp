import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testDiaryLogs {
    @Test
    public void testDiaryLoginSuccessful() {
        DiaryLogs logs = new DiaryLogs();
        Diary diary = new Diary("username","password");
        logs.addDiary(diary);
        Diary logging = logs.login("username","password");
        assertNotNull(logging);
        assertFalse(logging.isLocked(), "Dairy will unlock after the login is correct");
    }
    @Test
    public void testDiaryLoginFailedWrongPassword() {
        DiaryLogs logs = new DiaryLogs();
        Diary diary = new Diary("username","password");

        logs.addDiary(diary);
        Diary loggingFailed = logs.login("username","pass123");
        assertNull(loggingFailed, "Dairy will unlock after the login is correct");
    }
    @Test
    public void testLoginFailedWrongUsername() {
        DiaryLogs logs = new DiaryLogs();
        Diary diary = new Diary("username","password");
        logs.addDiary(diary);
        Diary loggingFailed = logs.login("wrongUsername","password");
        assertNull(loggingFailed, "Dairy will unlock after the login is correct");


    }
    @Test
    public void testRegisterSuccessful() {
        DiaryLogs logs = new DiaryLogs();
        logs.registerUser(new Diary("username","password"));
        Diary logging = logs.login("username","password");
        assertNotNull(logging,"User will be logged in");
        assertFalse(logging.isLocked(),"Diary will be unlocked");
    }
    @Test
    public void testLoginWithUsername() {
        DiaryLogs logs = new DiaryLogs();
        Diary diary = new Diary("username","password");
        logs.addDiary(diary);
        Diary loggingSuccessful = logs.getDiaryWithUsername("username");
        assertNotNull(loggingSuccessful);
    }

}

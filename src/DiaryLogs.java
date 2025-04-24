import java.util.ArrayList;

public class DiaryLogs {
    private ArrayList<Diary> diaryList = new ArrayList<>();

    public void addDiary(Diary diary) {
        diaryList.add(diary);
    }

    public Diary login(String username, String password) {
        for (Diary diary : diaryList) {
            if (diary.getUserName().equals(username) && diary.getPassword().equals(password)) {
                diary.unLockDiary();
                return diary;
            }
        }
        return null;
    }
    public void registerUser(Diary diary) {
        Diary newDiary = new Diary(diary.getUserName(), diary.getPassword());
        diaryList.add(newDiary);
    }
    public Diary getDiaryWithUsername(String username) {
        for (Diary diary : diaryList) {
            if (diary.getUserName().equals(username)) {
                return diary;
            }
        }
        return null;
    }


}

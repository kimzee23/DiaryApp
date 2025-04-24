import java.util.ArrayList;
import java.util.List;

public class Diary {


    private String username;
    private String password;
    private boolean isLocked;
    private List<Entry> inputs= new ArrayList<>();

    public Diary(  String username, String password) {
        this.username = username;
        this.password = password;
        this.isLocked = true;
        this.inputs = new ArrayList<>();


    }

    public String getUserName() {
        return username;
    }

    public void setUsername(String newUsername) {
        if (newUsername == null || newUsername.trim().isEmpty()|| !newUsername.matches("[A-Za-z]+")) {
            throw new IllegalArgumentException("Username must be alphabetic and not empty");
        }
        this.username = newUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password = newPassword;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lockDiary() {
        this.isLocked =true;
    }

    public void unLockDiary() {
        this.isLocked =false;
    }

    public void addEntry(Entry diaryEntry) {
        inputs.add(diaryEntry);
    }

    public List<Entry> getInputs() {
        return inputs;
    }
    public  Entry findEntryById(int id) {
        for (Entry entry : inputs) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }


    public void editEntry(int i, String newTitle, String newBoy) {
        for (Entry entry : inputs) {
            if (entry.getId() == i) {
                entry.setTitle(newTitle);
                entry.setBody(newBoy);
                return;
            }
        }
        throw  new IllegalArgumentException("Entry ID not found");
    }

    public void deleteEntry(int i) {
        for (Entry entry : inputs) {
            if (entry.getId() == i) {
                inputs.remove(entry);
                return;
            }
        }
    }
//    public boolean usernameExists(String username) {
//        for (Diary diary : inputs) {
//            if (diary.getUserName().equalsIgnoreCase(username)) {
//                return true;
//            }
//        }
//        return false;
//    }

}
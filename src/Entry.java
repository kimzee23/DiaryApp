import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDate dateCreated;


    public Entry(int id, String title, String body, String date) {
        this.id = id;
        this.title = title;
        this.body = body;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateCreated = LocalDate.now();
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        return title;
    }

    public String getBody() {
        if (body == null || body.isEmpty()) {
            throw new IllegalArgumentException("Body cannot be empty");
        }
        return body;
    }

    public void setTitle(String newTitle) {
        if (newTitle == null || newTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = newTitle;
    }

    public void setBody(String newBody) {
        if (newBody == null || newBody.trim().isEmpty()) {
            throw new IllegalArgumentException("Body cannot be null or empty");
        }
        this.body = newBody;
    }
    public LocalDate getDateCreated() {
        return dateCreated;
    }

}


package Dsa;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Entry implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final int id;
    private String title;
    private String body;
    private final LocalDateTime dateCreated;

    public Entry(int id, String title, String body, LocalDateTime dateCreated) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isBlank()) {
            this.title = title;
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        if (body != null && !body.isBlank()) {
            this.body = body;
        }
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}

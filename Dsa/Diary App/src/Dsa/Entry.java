package Dsa;

import java.time.LocalDateTime;

public class Entry {
    private final int id;
    private String title;
    private String body;
    private final LocalDateTime dateCreated = LocalDateTime.now().withSecond(0).withNano(0);

    public Entry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
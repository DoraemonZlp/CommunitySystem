package twt.model;

import java.util.Date;

public class Announcement {

    private int id;

    private int publisher;

    private Date time;

    private String content;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPublisher() {
        return publisher;
    }
    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
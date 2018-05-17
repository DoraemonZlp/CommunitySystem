package twt.model;

import java.util.Date;

public class Comment {

    private int id;

    private int household;

    private Date time;

    private String content;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getHousehold() {
        return household;
    }
    public void setHousehold(int household) {
        this.household = household;
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
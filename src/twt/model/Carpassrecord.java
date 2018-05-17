package twt.model;

import java.util.Date;

public class Carpassrecord {

    private int id;

    private Date time;

    private int door;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public int getDoor() {
        return door;
    }
    public void setDoor(int door) {
        this.door = door;
    }

}
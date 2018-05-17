package twt.model;


public class Repair {

    private int id;

    private int roomid;

    private String content;

    private int isfixed;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getRoomid() {
        return roomid;
    }
    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getIsfixed() {
        return isfixed;
    }
    public void setIsfixed(int isfixed) {
        this.isfixed = isfixed;
    }

}
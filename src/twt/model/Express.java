package twt.model;

import java.util.Date;

public class Express {

    private int id;

    private String number;

    private Date time;

    private String phone;

    private int picked;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getPicked() {
        return picked;
    }
    public void setPicked(int picked) {
        this.picked = picked;
    }

}
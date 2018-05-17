package twt.model;

import java.util.Date;

public class Household {

    private int id;

    private String name;

    private String phone;

    private int sex;

    private Date birthday;

    private int type;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

}
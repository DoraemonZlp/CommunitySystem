package twt.model;

import java.util.Date;

public class Guard {

    private int id;

    private String name;

    private String phone;

    private int sex;

    private Date birthday;

    private Date starttime;

    private Date stoptime;

    private int salary;

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
    public Date getStarttime() {
        return starttime;
    }
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
    public Date getStoptime() {
        return stoptime;
    }
    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

}
package twt.controller.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.opensymphony.xwork2.Action;

import twt.model.Announcement;
import twt.model.Car;
import twt.model.Comment;
import twt.model.Express;
import twt.model.Room;
import twt.model.UserPassRecord;

public class HouseholdAction implements Action{
	private Integer id;
	private String name;
	private String phone;
	private Integer sex;
	private Date birthday;
	private int type;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Car> cars = new HashSet<Car>(0);
	private Set<Express> expresses = new HashSet<Express>(0);
	private Set<Room> rooms = new HashSet<Room>(0);
	private Set<UserPassRecord> userPassRecords = new HashSet<UserPassRecord>(0);
	private Set<Announcement> announcements = new HashSet<Announcement>(0);
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", nullable = false, length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday", length = 19)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "type", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
	public Set<Car> getCars() {
		return this.cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
	public Set<Express> getExpresses() {
		return this.expresses;
	}

	public void setExpresses(Set<Express> expresses) {
		this.expresses = expresses;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "households")
	public Set<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
	public Set<UserPassRecord> getUserPassRecords() {
		return this.userPassRecords;
	}

	public void setUserPassRecords(Set<UserPassRecord> userPassRecords) {
		this.userPassRecords = userPassRecords;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "household")
	public Set<Announcement> getAnnouncements() {
		return this.announcements;
	}

	public void setAnnouncements(Set<Announcement> announcements) {
		this.announcements = announcements;
	}
    public String execute()throws Exception{
    	if (name.length()>0){
    		return "seccess";
    	}
    	else return "error";
    }
}

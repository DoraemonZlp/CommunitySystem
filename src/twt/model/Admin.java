package twt.model;

public class Admin {
	public int id;
	public String name;
	public String phone;
	public Admin(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;//123
	}
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
}

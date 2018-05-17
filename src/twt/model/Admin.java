package twt.model;

public class Admin {
	public int id;
	public String name;
	public String phone;
	public String t1;//1234
	
	public Admin(int id, String name, String phone) {
		super();
		this.id = id;
		this.phone = phone;
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

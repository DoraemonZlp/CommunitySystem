package twt.controller.service;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {

	private String UserName;
	private String Password;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String execute() {
		String res="error";
		System.out.println(getUserName());
		System.out.println(getPassword());
		if(getPassword().equals(getUserName())) {
			res="ok";
		}else {
			res="error";
		}
		return res;
	}
}

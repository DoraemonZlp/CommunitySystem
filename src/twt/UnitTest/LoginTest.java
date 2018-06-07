package twt.UnitTest;

import twt.controller.dao.LoginDao;
import twt.controller.dao.imp.ILoginDao;

public class LoginTest {
	
	public static void main(String[] args) {
		ILoginDao lg=new LoginDao();
		int r=lg.Login("13200000002", "888888");
		System.out.println(r);
	}

}

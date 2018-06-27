package twt.UnitTest;

import java.text.ParseException;
import java.util.List;

import twt.controller.DateHandle;
import twt.controller.dao.GuardDao;
import twt.controller.dao.imp.IGuard;
import twt.model.Guard;
import twt.model.Household;

public class GuardTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
IGuard guard=new GuardDao();
int id=guard.insertGuard(new Guard("韩卫华","15557894251",1,DateHandle.date("1895-01-15 00:00:00"),DateHandle.date("1915-01-15 00:00:00"),DateHandle.date("1965-12-15 00:00:00"),3500));
List<Guard>guards=guard.showGuard(1);
for(Guard r:guards) {
	System.out.println(r.getName());
}
	}

}

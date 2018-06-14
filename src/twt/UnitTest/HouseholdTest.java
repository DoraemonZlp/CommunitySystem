package twt.UnitTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import twt.controller.dao.HouseholdDao;
import twt.controller.dao.RepairDao;
import twt.controller.dao.imp.IHousehold;
import twt.controller.dao.imp.IRepair;
import twt.model.Household;
import twt.model.Repair;
import twt.model.Room;

public class HouseholdTest {
	public static void householdTest() throws ParseException {
		IHousehold a=new HouseholdDao();
		/*Room room=new Room();
		room.setId(1);*/
		
		int id=a.insertHousehold(new Household("李斯","13337000123",1,date("1986-02-18 56:45:00"),0));
		//re.UpdateRepair(1, new Repair(room,"电视机坏了",0));
		//re.RepairRepair(1);
		//re.DeleteRepair(id);
		List<Household>as=a.showHousehold(-1);
		for(Household r:as) {
			System.out.println(r.getName());
		}
	}
	public static Date date(String birth) throws ParseException{
		SimpleDateFormat bartDateFormat = 
				new SimpleDateFormat("yyyy-MM-dd");
				Date date = bartDateFormat.parse(birth);
				return date; 
				
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		householdTest();
	
	}

}

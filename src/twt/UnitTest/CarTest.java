package twt.UnitTest;

import java.text.ParseException;
import java.util.List;

import twt.controller.DateHandle;
import twt.controller.dao.CarDao;
import twt.controller.dao.HouseholdDao;
import twt.controller.dao.imp.ICarManage;
import twt.controller.dao.imp.IHousehold;
import twt.model.Car;
import twt.model.Household;

public class CarTest {
	// TODO Auto-generated method stub
	public static void carTest() throws ParseException {
	   ICarManage car=new CarDao();
	   IHousehold housuhold=new HouseholdDao();
	   Household hd=new Household("王武","13337213123",1,DateHandle.date("1987-02-18 56:45:00"),0);
	   int id1 =housuhold.insertHousehold(hd);
	   int id2=car.insertCar(new Car(hd,"浙F12345"));
	   List<Car>cars=car.showCars(1);
		for(Car r:cars) {
			System.out.println(r.getNumber());
		}
	}
	public static void main(String[] args) throws ParseException  {
		carTest();
	}
}

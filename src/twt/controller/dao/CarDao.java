package twt.controller.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.ICarManage;
import twt.model.Car;
import twt.model.CarPassRecord;
import twt.model.Guard;
import twt.model.Household;

public class CarDao implements ICarManage{
	public CarDao() {
		MyGlobal.init();
	}
	
	//车辆插入
public int insertCar(Car car){
	MyGlobal.begintrans();
	MyGlobal.session.save(car);
	MyGlobal.commit();
	return car.getId();
}

   //车辆更新
public boolean updateCar(Car car,String number){
	MyGlobal.begintrans();
	Car Che=(Car) MyGlobal.session.get(Car.class, number);
	Che.setHousehold(car.getHousehold());
	Che.setNumber(car.getNumber());
	/*Che.setCarPassRecord(car.getCarPassRecord());*/
	MyGlobal.session.update(Che);
	MyGlobal.commit();
	return true;
}

   //车辆删除
public boolean deleteCar(Car car,String number){
	MyGlobal.begintrans();
	MyGlobal.session.delete(MyGlobal.session.get(Car.class, number));
	MyGlobal.commit();
	return true; 
}

   //车辆显示
public List<Car> showCars(int n){
	Query query = MyGlobal.session.createQuery("from Car");
	//query.setParameter(0, n);
	List<Car> cars;
	if(n>0) {
		cars =query.setMaxResults(n).list();//Hibernate可以使用Query.setMaxResults方法简单地设置需要查询的最大结果集
	}else {
		cars =query.list();
	}
	return cars;
}
  }


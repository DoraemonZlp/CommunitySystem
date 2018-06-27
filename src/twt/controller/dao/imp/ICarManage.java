package twt.controller.dao.imp;

import java.util.List;

import twt.model.Car;
import twt.model.CarPassRecord;
import twt.model.Household;

public interface ICarManage {
	
	//车辆插入
public int insertCar(Car car);

   //车辆更新
public boolean updateCar(Car car,String number);

   //车辆删除
public boolean deleteCar(Car car,String number);

   //车辆显示
public List<Car> showCars(int n);
}

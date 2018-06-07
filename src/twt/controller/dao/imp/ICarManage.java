package twt.controller.dao.imp;

import twt.model.CarPassRecord;
import twt.model.Household;

public interface ICarManage {
public boolean insertCar(Integer id, Household household, String number, CarPassRecord carPassRecord);
}

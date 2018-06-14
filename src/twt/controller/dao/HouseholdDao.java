package twt.controller.dao;

import java.util.List;

import org.apache.struts2.components.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.IHousehold;
import twt.model.Household;
import twt.model.Repair;

public class HouseholdDao implements IHousehold{
	public HouseholdDao() {
		MyGlobal.init();
	}

	//插入户主信息
    public int insertHousehold(Household household){
    	MyGlobal.begintrans();
		MyGlobal.session.save(household);
		MyGlobal.commit();
    	return household.getId();
    }
    //更新户主信息
    public boolean updateHousehold(Household house,String phone){
    	MyGlobal.begintrans();
    	Household hd=(Household) MyGlobal.session.get(Household.class, phone);
    	hd.setName(house.getName());
    	hd.setPhone(house.getPhone());
		hd.setSex(house.getSex());
		hd.setBirthday(house.getBirthday());
		hd.setType(house.getType());  //户主0，配偶1，儿子2，女儿3，父4，母5，朋友6，其它7
		MyGlobal.session.update(hd);
		MyGlobal.commit();
    	return true;
    }
    //删除户主信息
    public boolean deleteHousehold(String phone){
    	MyGlobal.begintrans();
		MyGlobal.session.delete(MyGlobal.session.get(Household.class, phone));
		MyGlobal.commit();
		return true; 
    }
    //显示户主信息
    public List<Household> showHousehold(int n){
    	Query query = MyGlobal.session.createQuery("from Household");
		//query.setParameter(0, n);
		List<Household> houses;
		if(n>0) {
			houses =query.setMaxResults(n).list();//Hibernate可以使用Query.setMaxResults方法简单地设置需要查询的最大结果集
		}else {
			houses =query.list();
		}
		return houses;
	}
    
}

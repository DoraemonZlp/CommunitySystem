package twt.controller.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.IGuard;
import twt.model.Guard;
import twt.model.Household;

public class GuardDao implements IGuard{
	public GuardDao() {
		MyGlobal.init();
	}

	//插入保安信息
    public int insertGuard(Guard gurad){
    	MyGlobal.begintrans();
		MyGlobal.session.save(gurad);
		MyGlobal.commit();
    	return gurad.getId();
    }
    //更新保安信息
    public boolean updateGuard(Guard gurad,String phone){
    	MyGlobal.begintrans();
    	Guard gd=(Guard) MyGlobal.session.get(Guard.class, phone);
    	gd.setName(gurad.getName());
    	gd.setPhone(gurad.getPhone());
		gd.setSex(gurad.getSex());
		gd.setBirthday(gurad.getBirthday());
		gd.setStarttime(gurad.getStarttime()); 
		gd.setStoptime(gurad.getStoptime());
		gd.setSalary(gurad.getSalary());
		MyGlobal.session.update(gd);
		MyGlobal.commit();
    	return true;
    }
    //删除保安信息
    @Override
    public boolean deleteGuard(String phone){
    	MyGlobal.begintrans();
		MyGlobal.session.delete(MyGlobal.session.get(Guard.class, phone));
		MyGlobal.commit();
		return true; 
    }
    //显示保安信息
    public List<Guard> showGuard(int n){
    	Query query = MyGlobal.session.createQuery("from Guard");
		//query.setParameter(0, n);
		List<Guard> guards;
		if(n>0) {
			guards =query.setMaxResults(n).list();//Hibernate可以使用Query.setMaxResults方法简单地设置需要查询的最大结果集
		}else {
			guards =query.list();
		}
		return guards;
	}

	
    
}

package twt.controller.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import twt.model.CarPassRecord;
import twt.model.Household;

public class CarDao {
		Session session=null;
		Transaction trans=null;
		SessionFactory sessionFactory=null;
		void init(){
			Configuration configuration = new Configuration();
			// 加载hibernate.cfg.xml文件
			configuration.configure("/hibernate.cfg.xml");
			// 创建SessionFactory
			// Hibernate4.3创建SessionFactory的方式
			StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
			standardServiceRegistryBuilder.applySettings(configuration
					.getProperties());
			sessionFactory = configuration
					.buildSessionFactory(standardServiceRegistryBuilder.build());
			// 打开Session
			session = sessionFactory.openSession();
			// 开始一个事务
			trans = session.beginTransaction();
	}
  public boolean insertCar(Integer id, Household household, String number, CarPassRecord carPassRecord){
	return true;  
  }
}

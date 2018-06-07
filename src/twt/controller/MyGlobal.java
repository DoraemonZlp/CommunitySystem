package twt.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MyGlobal {
	public static Session session=null;
	static Transaction trans=null;
	static SessionFactory sessionFactory=null;
	static boolean isinit=false;
	public static void init(){
		if(isinit)return;
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
		//trans = session.beginTransaction();
		isinit=true;
	}
	public static void begintrans() {
		trans = session.beginTransaction();
	}
	public static void commit() {
		trans.commit();
	}
}

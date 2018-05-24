package twt.UnitTest;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import twt.model.Admin;

public class Test1 {
	
	public static void main(String[] args) {
		// 实例化Configuration
		Configuration configuration = new Configuration();
		// 加载hibernate.cfg.xml文件
		configuration.configure("/hibernate.cfg.xml");
		// 创建SessionFactory
		// Hibernate4.3创建SessionFactory的方式
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.applySettings(configuration
				.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(standardServiceRegistryBuilder.build());
		// 打开Session
		Session session = sessionFactory.openSession();
		// 开始一个事务
		Transaction trans = session.beginTransaction();
		// 查询Customer表
		Query query = session.createQuery("from Admin");
		List<Admin> admins=query.list();
		for(Admin a:admins) {
			System.out.println(a.getName());
			a.setName("管理员001");
			session.save(a);  
	        session.flush();  
	        session.getTransaction().commit();  
		}
		sessionFactory.close();
	}

}

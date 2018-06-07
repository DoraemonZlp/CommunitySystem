package twt.controller.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import twt.controller.dao.imp.ILoginDao;
import twt.model.Admin;
import twt.model.Household;
import twt.model.LoginAdmin;
import twt.model.LoginAdminId;
import twt.model.LoginHousehold;
import twt.model.LoginHouseholdId;

public class LoginDao implements ILoginDao {
	Session session=null;
	//Transaction trans=null;
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
		//session = sessionFactory.openSession();
		// 开始一个事务
		//trans = session.beginTransaction();
	}
	public LoginDao() {
		init();
	}
	@Override
	public int Login(String phone,String pwd) {
		int r=-1;
		session = sessionFactory.openSession();
		Criteria query =session.createCriteria(LoginAdmin.class);
		query.add(Restrictions.eq("id.phone",phone));
		query.add(Restrictions.eq("id.password",pwd));
		List<LoginAdmin> admins=query.list();
		if(admins.size()>0) {
//			for(LoginAdmin admin:admins) {
//				System.out.println(admin.getId().getName());
//			}
			r= 0;
		}
		query =session.createCriteria(LoginHousehold.class);
		query.add(Restrictions.eq("id.phone",phone));
		query.add(Restrictions.eq("id.password",pwd));
		List<LoginHousehold> households=query.list();
		if(households.size()>0) {
			r= 1;
		}
		//trans.commit();
		sessionFactory.close();
		return r;
	}
}

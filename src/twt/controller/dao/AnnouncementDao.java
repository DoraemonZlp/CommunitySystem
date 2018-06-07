package twt.controller.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import twt.controller.dao.imp.IAnnouncement;
import twt.model.Announcement;

public class AnnouncementDao implements IAnnouncement{
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
		//trans = session.beginTransaction();
	}
	public AnnouncementDao() {
		init();
	}
	@Override
	public int PublishAnnouncement(Announcement an) {
		trans = session.beginTransaction();
		session.save(an);
		trans.commit();
		return 1;
	}

	@Override
	public List<Announcement> QueryAnnouncement(int n) {
		//trans = session.beginTransaction();
		Query query = session.createQuery("from Announcement");
		//query.setParameter(0, n);
		List<Announcement> ans =query.setMaxResults(n).list();
		//trans.commit();
		return ans;
	}

	@Override
	public int UpdateAnnouncement(int id, Announcement an) {
		trans = session.beginTransaction();
		Announcement oan=(Announcement) session.get(Announcement.class, id);
		//System.out.println(oan.getContent());
		oan.setAdmin(an.getAdmin());
		oan.setContent(an.getContent());
		oan.setTime(an.getTime());
		session.update(oan);
		trans.commit();
		return 0;
	}

	@Override
	public int DeleteAnnouncement(int id) {
		trans = session.beginTransaction();
		session.delete(session.get(Announcement.class, id));
		trans.commit();
		return 0;
	}
}

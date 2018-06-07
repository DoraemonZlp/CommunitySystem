package twt.controller.dao;

import java.util.List;

import org.hibernate.Query;
import twt.controller.MyGlobal;
import twt.controller.dao.imp.IAnnouncement;
import twt.model.Announcement;

public class AnnouncementDao implements IAnnouncement{
	public AnnouncementDao() {
		MyGlobal.init();
	}
	@Override
	public int PublishAnnouncement(Announcement an) {
		int r=0;
		MyGlobal.begintrans();
		try {
			MyGlobal.session.save(an);
			MyGlobal.commit();
			r=an.getId();
		} catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public List<Announcement> QueryAnnouncement(int n) {
		//trans = session.beginTransaction();
		Query query = MyGlobal.session.createQuery("from Announcement");
		//query.setParameter(0, n);
		List<Announcement> ans;
		if(n>0) {
			ans =query.setMaxResults(n).list();
		}else {
			ans =query.list();
		}
		//trans.commit();
		return ans;
	}

	@Override
	public int UpdateAnnouncement(int id, Announcement an) {
		int r=0;
		MyGlobal.begintrans();
		try {
			Announcement oan=(Announcement) MyGlobal.session.get(Announcement.class, id);
			//System.out.println(oan.getContent());
			oan.setAdmin(an.getAdmin());
			oan.setContent(an.getContent());
			oan.setTime(an.getTime());
			MyGlobal.session.update(oan);
			MyGlobal.commit();
			r=1;
		} catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int DeleteAnnouncement(int id) {
		int r=0;
		MyGlobal.begintrans();
		try {
			MyGlobal.session.delete(MyGlobal.session.get(Announcement.class, id));
			MyGlobal.commit();
			r=1;
		} catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}
}

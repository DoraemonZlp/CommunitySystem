package twt.controller.dao;

import java.util.List;

import org.hibernate.Query;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.IRepair;
import twt.model.Repair;

public class RepairDao implements IRepair {
	
	public RepairDao() {
		MyGlobal.init();
	}

	@Override
	public int PublishRepair(Repair re) {
		int r=0;
		MyGlobal.begintrans();
		try {
			MyGlobal.session.save(re);
			MyGlobal.commit();
			r=re.getId();
		}catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int UpdateRepair(int id, Repair re) {
		int r=0;
		MyGlobal.begintrans();
		try {
			Repair or=(Repair) MyGlobal.session.get(Repair.class, id);
			//System.out.println(oan.getContent());
			or.setContent(re.getContent());
			or.setIsfixed(re.getIsfixed());
			or.setRoom(re.getRoom());
			MyGlobal.session.update(or);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int DeleteRepair(int id) {
		int r=0;
		MyGlobal.begintrans();
		try {
			MyGlobal.session.delete(MyGlobal.session.get(Repair.class, id));
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int RepairRepair(int id) {
		int r=0;
		MyGlobal.begintrans();
		try {
			Repair or=(Repair) MyGlobal.session.get(Repair.class, id);
			or.setIsfixed(1);
			MyGlobal.session.update(or);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public List<Repair> QueryRepair(int n) {
		Query query = MyGlobal.session.createQuery("from Repair");
		//query.setParameter(0, n);
		List<Repair> ans;
		if(n>0) {
			ans =query.setMaxResults(n).list();
		}else {
			ans =query.list();
		}
		return ans;
	}

}

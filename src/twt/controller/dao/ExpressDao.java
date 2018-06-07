/**
 * 
 */
package twt.controller.dao;

import java.util.List;

import org.hibernate.Query;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.IExpress;
import twt.model.Express;

/**
 * @author 我啊
 *
 */
public class ExpressDao implements IExpress {
	
	public ExpressDao() {
		MyGlobal.init();
	}

	@Override
	public List<Express> QueryExpressByPhone(String phone) {
		Query query = MyGlobal.session.createQuery("from Express where phone=?");
		query.setParameter(0, phone);
		List<Express> res;
		res=query.list();
		return res;
	}

	@Override
	public List<Express> QueryUnpickedExpressByPhone(String phone) {
		Query query = MyGlobal.session.createQuery("from Express where phone=? and picked=?");
		query.setParameter(0, phone);
		query.setParameter(1, 0);
		List<Express> res;
		res=query.list();
		return res;
	}

	@Override
	public int PickExpress(int id) {
		int r=0;
		MyGlobal.begintrans();
		try {
			Express old=(Express) MyGlobal.session.get(Express.class, id);
			old.setPicked(1);
			MyGlobal.session.update(old);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int AddExpress(Express exp) {
		int r=0;
		MyGlobal.begintrans();
		try {
			MyGlobal.session.save(exp);
			MyGlobal.commit();
			r=exp.getId();
		}catch (Exception e) {
			System.out.println("失败"+e.toString());
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int DeleteExpress(int id) {
		int r=0;
		MyGlobal.begintrans();
		try {
			MyGlobal.session.delete(MyGlobal.session.get(Express.class, id));
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int UpdateExpress(int id, Express exp) {
		int r=0;
		MyGlobal.begintrans();
		try {
			Express old=(Express) MyGlobal.session.get(Express.class, id);
			old.setHousehold(exp.getHousehold());
			old.setNumber(exp.getNumber());
			old.setPicked(exp.getPicked());
			old.setTime(exp.getTime());
			MyGlobal.session.update(old);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public List<Express> QueryExpress(int num) {
		Query query = MyGlobal.session.createQuery("from Express");
		List<Express> res;
		if(num>0) {
			res =query.setMaxResults(num).list();
		}else {
			res =query.list();
		}
		return res;
	}

	@Override
	public List<Express> QueryUnpickedExpress(int num) {
		Query query = MyGlobal.session.createQuery("from Express where picked=?");
		query.setParameter(1, 0);
		List<Express> res;
		if(num>0) {
			res =query.setMaxResults(num).list();
		}else {
			res =query.list();
		}
		return res;
	}

}

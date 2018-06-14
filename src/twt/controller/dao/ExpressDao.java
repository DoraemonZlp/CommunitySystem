/**
 * 
 */
package twt.controller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.IExpress;
import twt.model.Express;
import twt.model.Household;

/**
 * @author 我啊
 *
 */
public class ExpressDao implements IExpress {
	
	public ExpressDao() {
		//MyGlobal.init();
	}

	@Override
	public List<Express> QueryExpressByPhone(String phone) {
		List<Express> res = new ArrayList<Express>();
		SQLDao.init();
		String sql="select * from Express where phone ="+phone;
		try {
			ResultSet rs = SQLDao.stmt.executeQuery(sql);
			while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String number = rs.getString("number");
                Date time =rs.getDate("time");
                int picked=rs.getInt("picked");
                Household h=new Household();
                h.setPhone(phone);
                Express e=new Express(h,number,time,picked);
                e.setId(id);
                res.add(e);
            }
            // 完成后关闭
            rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Express> QueryUnpickedExpressByPhone(String phone) {
		List<Express> res = new ArrayList<Express>();
		SQLDao.init();
		String sql="select * from Express where phone = "+phone+" and picked = 0";
		try {
			ResultSet rs = SQLDao.stmt.executeQuery(sql);
			while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String number = rs.getString("number");
                Date time =rs.getDate("time");
                int picked=rs.getInt("picked");
                Household h=new Household();
                h.setPhone(phone);
                Express e=new Express(h,number,time,picked);
                e.setId(id);
                res.add(e);
            }
            // 完成后关闭
            rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int PickExpress(int id) {
		int r=0;
		SQLDao.init();
		String sql="UPDATE `Express` SET `picked`='"+1+"' WHERE (`id`='"+id+"') LIMIT 1";
		try {
			SQLDao.stmt.execute(sql);
			r=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		MyGlobal.begintrans();
//		try {
//			Express old=(Express) MyGlobal.session.get(Express.class, id);
//			old.setPicked(1);
//			MyGlobal.session.update(old);
//			MyGlobal.commit();
//			r=1;
//		}catch (Exception e) {
//			MyGlobal.rollback();
//		}
		return r;
	}

	public static String fmttime(Date d) {
		String t=d.getYear()+"-"+d.getMonth()+"-"+d.getDate()
			+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
		return t;
	}
	
	@Override
	public int AddExpress(Express exp) {
		int r=0;
		SQLDao.init();
		String sql="INSERT INTO `Express` (`number`, `time`, `phone`, `picked`) VALUES ("
				+ "'"+exp.getNumber()+"', '"+fmttime(exp.getTime())+"', '"
				+exp.getHousehold().getPhone()+"', '"+exp.getPicked()+"')";
		try {
			SQLDao.stmt.execute(sql);
			r=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//SQLDao.close();
//		MyGlobal.begintrans();
//		try {
//			//
//			Query query = MyGlobal.session.createQuery("from Household where phone=?");
//			query.setParameter(0, exp.getHousehold().getPhone());
//			List<Household> res;
//			res=query.list();
//			Household h=res.get(0);
//			//System.out.println(h.getName());
//			Household hh=(Household) MyGlobal.session.load(Household.class, h.getId());
//			System.out.println(hh.getName());
//			System.out.println(exp.getTime());
//			exp.setHousehold(hh);
//			//
//			MyGlobal.session.save(exp);
//			MyGlobal.commit();
//			r=exp.getId();
//		}catch (Exception e) {
//			System.out.println("失败"+e.toString());
//			MyGlobal.rollback();
//		}
		return r;
	}

	@Override
	public int DeleteExpress(int id) {
		int r=0;
		String sql="DELETE FROM `Express` WHERE (`id`='"+id+"')";
		SQLDao.init();
		try {
			SQLDao.stmt.execute(sql);
			r=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		MyGlobal.begintrans();
//		try {
//			MyGlobal.session.delete(MyGlobal.session.get(Express.class, id));
//			MyGlobal.commit();
//			r=1;
//		}catch (Exception e) {
//			System.out.println("失败"+e.toString());
//			MyGlobal.rollback();
//		}
		return r;
	}

	@Override
	public int UpdateExpress(int id, Express exp) {
		int r=0;
		SQLDao.init();
		String sql="UPDATE `Express` SET `number`='"+exp.getNumber()+"', "
				+ "`time`='"+fmttime(exp.getTime())+"', `phone`='"+exp.getHousehold().getPhone()+"',"
						+ " `picked`='"+exp.getPicked()+"' WHERE (`id`='"+id+"') LIMIT 1";
		try {
			SQLDao.stmt.execute(sql);
			r=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		MyGlobal.begintrans();
//		try {
//			Express old=(Express) MyGlobal.session.get(Express.class, id);
//			old.setHousehold(exp.getHousehold());
//			old.setNumber(exp.getNumber());
//			old.setPicked(exp.getPicked());
//			old.setTime(exp.getTime());
//			MyGlobal.session.update(old);
//			MyGlobal.commit();
//			r=1;
//		}catch (Exception e) {
//			MyGlobal.rollback();
//		}
		return r;
	}

	@Override
	public List<Express> QueryExpress(int num) {
		List<Express> res = new ArrayList<Express>();
		SQLDao.init();
		String sql="select * from Express"+(num>0?" limit "+num:" ");
		try {
			ResultSet rs = SQLDao.stmt.executeQuery(sql);
			while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String number = rs.getString("number");
                String phone = rs.getString("phone");
                Date time =rs.getDate("time");
                int picked=rs.getInt("picked");
                Household h=new Household();
                h.setPhone(phone);
                Express e=new Express(h,number,time,picked);
                e.setId(id);
                res.add(e);
            }
            // 完成后关闭
            rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Query query = MyGlobal.session.createQuery("from Express");
//		if(num>0) {
//			res =query.setMaxResults(num).list();
//		}else {
//			res =query.list();
//		}
		return res;
	}

	@Override
	public List<Express> QueryUnpickedExpress(int num) {
		List<Express> res = new ArrayList<Express>();
		SQLDao.init();
		String sql="select * from Express where picked = 0"+(num>0?" limit "+num:" ");
		try {
			ResultSet rs = SQLDao.stmt.executeQuery(sql);
			while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String number = rs.getString("number");
                Date time =rs.getDate("time");
                int picked=rs.getInt("picked");
                String phone = rs.getString("phone");
                Household h=new Household();
                h.setPhone(phone);
                Express e=new Express(h,number,time,picked);
                e.setId(id);
                res.add(e);
            }
            // 完成后关闭
            rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}

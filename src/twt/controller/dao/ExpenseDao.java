package twt.controller.dao;

import java.util.List;

import org.hibernate.Query;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.IExpense;
import twt.model.Expense;
import twt.model.ExpenseId;
import twt.model.Repair;

public class ExpenseDao implements IExpense {

	public ExpenseDao() {
		MyGlobal.init();
	}
	
	@Override
	public Expense GetExpense(int roomid, int yearmonth) {
		Query query = MyGlobal.session.createQuery("from Expense where id.id = ? and id.yearmonth = ? ");
		query.setParameter(0, roomid);
		query.setParameter(1, yearmonth);
		List<Expense> list = query.list();
		if(list.size()==0)return null;
		return list.get(0);
	}

	@Override
	public int AddExpense(Expense exp) {
		int r=0;
		MyGlobal.begintrans();
		try {
			MyGlobal.session.save(exp);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			System.out.println(e);
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int UpdateExpense(int roomid,int yearmonth, Expense exp) {
		int r=0;
		MyGlobal.begintrans();
		try {
			Expense oe=(Expense) MyGlobal.session.get(Expense.class, new ExpenseId(roomid,yearmonth));
			//System.out.println(oan.getContent());
			oe.setElectricity(exp.getElectricity());
			oe.setElectricityed(exp.getElectricityed());
			oe.setGas(exp.getGas());
			oe.setGased(exp.getGas());
			oe.setWater(exp.getWater());
			oe.setWatered(exp.getWatered());
			MyGlobal.session.update(oe);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			System.out.println(e);
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int DeleteExpense(int roomid,int yearmonth) {
		int r=0;
		MyGlobal.begintrans();
		try {
			MyGlobal.session.delete(MyGlobal.session.get(Expense.class, new ExpenseId(roomid,yearmonth)));
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			System.out.println(e);
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public List<Expense> QueryExpense(int roomid) {
		Query query = MyGlobal.session.createQuery("from Expense where room.id = ?");
		query.setParameter(0, roomid);
		List<Expense> list = query.list();
		return list;
	}

	@Override
	public List<Expense> QueryExpense() {
		Query query = MyGlobal.session.createQuery("from Expense");
		//query.setParameter(0, n);
		List<Expense> ans;
		ans =query.list();
		return ans;
	}

	@Override
	public int Paywater(int roomid,int yearmonth, int money) {
		int r=0;
		try {
			MyGlobal.begintrans();
			Expense oe=(Expense) MyGlobal.session.get(Expense.class, new ExpenseId(roomid,yearmonth));
			oe.setWatered(oe.getWater()+money);
			MyGlobal.session.update(oe);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			System.out.println(e);
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int Payelectricity(int roomid,int yearmonth, int money) {
		int r=0;
		try {
			MyGlobal.begintrans();
			Expense oe=(Expense) MyGlobal.session.get(Expense.class, new ExpenseId(roomid,yearmonth));
			oe.setElectricityed(oe.getElectricity()+money);
			MyGlobal.session.update(oe);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			System.out.println(e);
			MyGlobal.rollback();
		}
		return r;
	}

	@Override
	public int Payelgas(int roomid,int yearmonth, int money) {
		int r=0;
		try {
			MyGlobal.begintrans();
			Expense oe=(Expense) MyGlobal.session.get(Expense.class, new ExpenseId(roomid,yearmonth));
			oe.setGased(oe.getGas()+money);
			MyGlobal.session.update(oe);
			MyGlobal.commit();
			r=1;
		}catch (Exception e) {
			System.out.println(e);
			MyGlobal.rollback();
		}
		return r;
	}

}

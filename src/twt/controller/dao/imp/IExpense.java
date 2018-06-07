package twt.controller.dao.imp;

import java.util.List;

import twt.model.Expense;

public interface IExpense {
	
	//获取roomid某年某月的账单信息
	public Expense GetExpense(int roomid ,int yearmonth);
	
	//添加一条账单信息
	public int AddExpense(Expense exp);
	
	//修改账单信息
	public int UpdateExpense(int roomid,Expense exp);
	
	//删除账单信息
	public int DeleteExpense(int roomid);
	
	//查询某房间所有账单信息
	public List<Expense> QueryExpense(int roomid);
	
	//查询所有账单信息
	public List<Expense> QueryExpense();
	
	//交水费
	public int Paywater(int roomid,int money);
	
	//交电费
	public int Payelectricity(int roomid,int money);
	
	//交煤气费
	public int Payelgas(int roomid,int money);
	
}

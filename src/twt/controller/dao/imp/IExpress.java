package twt.controller.dao.imp;

import java.util.List;

import twt.model.Express;

public interface IExpress {
	
	//查询某电话的快递信息
	public List<Express> QueryExpressByPhone(String phone);
	
	//查询所有快递
	public List<Express> QueryExpress(int num);
	
	//查询所有未签收快递
	public List<Express> QueryUnpickedExpress(int num);
	
	//查询某电话的未签收快递
	public List<Express> QueryUnpickedExpressByPhone(String phone);
	
	//签收快递
	public int PickExpress(int id);
	
	//添加快递，返回id
	public int AddExpress(Express exp);
	
	//删除快递
	public int DeleteExpress(int id);
	
	//修改快递
	public int UpdateExpress(int id,Express exp);
	
}

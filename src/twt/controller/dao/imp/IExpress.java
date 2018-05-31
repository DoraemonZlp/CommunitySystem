package twt.controller.dao.imp;

import java.util.List;

import twt.model.Express;

public interface IExpress {
	
	//查询某电话的快递信息
	public List<Express> QueryExpress(String phone);
	
	//查询未签收快递
	public List<Express> QueryUnpickedExpress(String phone);
	
	//签收快递
	public int PickExpress(int id);
	
	//添加快递
	public int AddExpress(Express exp);
	
	//删除快递
	public int DeleteExpress(int id);
	
	//修改快递
	public int UpdateExpress(int id,Express exp);
	
}

package twt.controller.dao.imp;

import java.util.List;

import twt.model.Repair;

public interface IRepair {
	
	//发布报修信息,返回保修id
	public int PublishRepair(Repair re);
	
	//修改报修信息
	public int UpdateRepair(int id,Repair re);
	
	//删除报修信息
	public int DeleteRepair(int id);
	
	//将某条报修信息设置为已修复
	public int RepairRepair(int id);
	
	//查看前n条报修信息,-1为所有报修信息
	public List<Repair> QueryRepair(int n);
	
}

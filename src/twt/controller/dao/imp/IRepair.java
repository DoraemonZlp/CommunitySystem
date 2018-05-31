package twt.controller.dao.imp;

import twt.model.Repair;

public interface IRepair {
	
	//发布报修信息
	public int PublishRepair(Repair re);
	
	//修改报修信息
	public int UpdateRepair(int id,Repair re);
	
	//删除报修信息
	public int DeleteRepair(int id);
	
	//将某条报修信息设置为已修复
	public int RepairRepair(int id);
	
	//提交操作
	public void Commit();
	
	//关闭连接
	public void Close();
	
}

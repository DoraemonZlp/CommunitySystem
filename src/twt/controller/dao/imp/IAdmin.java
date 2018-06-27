package twt.controller.dao.imp;

import twt.model.Admin;

public interface IAdmin {
   //管理员添加
	public int insertAdmin(Admin admin);
	//管理员修改
	public boolean updateAdmin(Admin admin,String phone);
	//管理员删除
	public boolean deleteAdmin(Admin admin,String phone);
}

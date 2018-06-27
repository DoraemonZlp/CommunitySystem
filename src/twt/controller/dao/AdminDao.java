package twt.controller.dao;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.IAdmin;
import twt.model.Admin;
import twt.model.Guard;

public class AdminDao implements IAdmin{
	public AdminDao() {
		MyGlobal.init();
	}
	//管理员添加
		public int insertAdmin(Admin admin){
			MyGlobal.begintrans();
			MyGlobal.session.save(admin);
			MyGlobal.commit();
	    	return admin.getId();
		}
		//管理员修改
		public boolean updateAdmin(Admin admin,String phone){
			MyGlobal.begintrans();
			Admin ad=(Admin) MyGlobal.session.get(Admin.class, phone);
	    	ad.setName(admin.getName());
	    	ad.setPhone(admin.getPhone());
			
			MyGlobal.session.update(ad);
			MyGlobal.commit();
	    	return true;
		}
		//管理员删除
		public boolean deleteAdmin(Admin admin,String phone){
			MyGlobal.begintrans();
			MyGlobal.session.delete(MyGlobal.session.get(Admin.class, phone));
			MyGlobal.commit();
			return true; 
		}
}

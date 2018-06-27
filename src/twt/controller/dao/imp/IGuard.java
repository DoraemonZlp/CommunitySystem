package twt.controller.dao.imp;

import java.util.Date;
import java.util.List;

import twt.model.Guard;
import twt.model.Household;

public interface IGuard {
			//插入保安信息
		public int insertGuard(Guard gurad);
		
      		//更新保安信息
      	public boolean updateGuard(Guard gurad,String phone);

    		//删除保安信息
    	public boolean deleteGuard(String phone);

    		//显示保安信息
    	public List<Guard> showGuard(int n);
    	
}

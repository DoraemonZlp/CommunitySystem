package twt.controller.dao.imp;

import java.util.List;

import org.apache.struts2.components.Date;


import twt.model.Household;

public interface IHousehold {
	//插入户主信息
     public int insertHousehold(Household household);
     
     //更新户主信息
     public boolean updateHousehold(Household house,String phone);
     
     //删除户主信息
     public boolean deleteHousehold(String phone);
     
     //显示户主信息
     public List<Household> showHousehold(int n);
     
}

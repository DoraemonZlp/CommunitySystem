package twt.controller.dao.imp;

import org.apache.struts2.components.Date;

public interface IHousehold {
     public boolean insertHousehold(int id,String name,String phone,int sex,Date birthday,int type);
}

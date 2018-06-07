package twt.controller.dao.imp;

import java.util.Date;

public interface IGuard {
public boolean insertGuard( Integer id, String name, String phone, Integer sex, Date birthday, Date starttime, Date stoptime, int salary);
}

package twt.UnitTest;

import java.util.Date;
import java.util.List;

import twt.controller.dao.AnnouncementDao;
import twt.controller.dao.ExpressDao;
import twt.controller.dao.RepairDao;
import twt.controller.dao.imp.IAnnouncement;
import twt.controller.dao.imp.IExpress;
import twt.controller.dao.imp.IRepair;
import twt.model.Admin;
import twt.model.Announcement;
import twt.model.Express;
import twt.model.Household;
import twt.model.Repair;
import twt.model.Room;

public class UnitTest {

	public static void AddAnnouncementTest() {
		IAnnouncement an=new AnnouncementDao();
		Admin ad=new Admin();
		ad.setId(1);
		an.PublishAnnouncement(new Announcement(ad,new java.util.Date(),"测试002"));
		//an.PublishAnnouncement(new Announcement(ad,new java.util.Date(),"公告内容"));
		List<Announcement>ans=an.QueryAnnouncement(2);
		for(Announcement a:ans) {
			System.out.println(a.getContent());
		}
		//an.UpdateAnnouncement(36, new Announcement(ad,new java.util.Date(),"修改公告"));
		//an.DeleteAnnouncement(36);
		
	}
	
	public static void RepairTest() {
		IRepair re=new RepairDao();
		Room room=new Room();
		room.setId(1);
		int id=re.PublishRepair(new Repair(room,"家里水管炸了",0));
		//re.UpdateRepair(1, new Repair(room,"电视机坏了",0));
		//re.RepairRepair(1);
		//re.DeleteRepair(id);
		List<Repair>res=re.QueryRepair(-1);
		for(Repair r:res) {
			System.out.println(r.getContent());
		}
	}
	
	public static void ExpressTest() {
		IExpress exp=new ExpressDao();
		Household hh=new Household();
		//hh.setId(1);
		hh.setPhone("13200000002");
		//exp.AddExpress(new Express(hh,"123456798",new Date(),0));
		//exp.DeleteExpress(18);
		//exp.UpdateExpress(19, new Express(hh,"88888",new Date(),0));
		//exp.PickExpress(20);
		List<Express>res=exp.QueryUnpickedExpress(-1);
		for(Express r:res) {
			System.out.println(r.getNumber());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AddAnnouncementTest();
		//RepairTest();
		ExpressTest();
	}

}

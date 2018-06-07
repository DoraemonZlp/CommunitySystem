package twt.UnitTest;

import java.util.List;

import twt.controller.dao.AnnouncementDao;
import twt.controller.dao.imp.IAnnouncement;
import twt.model.Admin;
import twt.model.Announcement;

public class UnitTest {

	public static void AddAnnouncementTest() {
		AnnouncementDao an=new AnnouncementDao();
		Admin ad=new Admin();
		ad.setId(1);
		//an.PublishAnnouncement(new Announcement(ad,new java.util.Date(),"测试002"));
		//an.PublishAnnouncement(new Announcement(ad,new java.util.Date(),"测试003"));
//		List<Announcement>ans=an.QueryAnnouncement(1);
//		for(Announcement a:ans) {
//			System.out.println(a.getContent());
//		}
		//an.UpdateAnnouncement(34, new Announcement(ad,new java.util.Date(),"修改002"));
		an.DeleteAnnouncement(35);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddAnnouncementTest();
	}

}

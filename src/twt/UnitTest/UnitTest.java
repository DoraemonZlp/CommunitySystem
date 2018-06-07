package twt.UnitTest;

import twt.controller.dao.AnnouncementDao;
import twt.controller.dao.imp.IAnnouncement;
import twt.model.Admin;
import twt.model.Announcement;

public class UnitTest {

	public static void AddAnnouncementTest() {
		AnnouncementDao announcement=new AnnouncementDao();
		Admin ad=new Admin();
		ad.setId(1);
		announcement.PublishAnnouncement(new Announcement(ad,new java.util.Date(),"测试002"));
		announcement.PublishAnnouncement(new Announcement(ad,new java.util.Date(),"测试003"));
		announcement.PublishAnnouncement(new Announcement(ad,new java.util.Date(),"测试004"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddAnnouncementTest();
	}

}

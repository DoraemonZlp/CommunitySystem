package twt.controller.dao.imp;

import java.util.List;

import twt.model.Announcement;

public interface IAnnouncement {
	
	//发布公告
	public int PublishAnnouncement(Announcement an);
	
	//查看前n条公告,-1为所有公告
	public List<Announcement> QueryAnnouncement(int n);
	
	//修改公告
	public int UpdateAnnouncement(int id,Announcement an);
	
	//删除公告
	public int DeleteAnnouncement(int id);
	
}

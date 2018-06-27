package twt.UnitTest;

import java.text.ParseException;
import java.util.List;

import twt.controller.DateHandle;
import twt.controller.dao.AdminDao;
import twt.controller.dao.CommentDao;
import twt.controller.dao.CommentReplyDao;
import twt.controller.dao.HouseholdDao;
import twt.controller.dao.imp.IAdmin;
import twt.controller.dao.imp.IComment;
import twt.controller.dao.imp.ICommentReply;
import twt.controller.dao.imp.IHousehold;
import twt.model.Admin;
import twt.model.Comment;
import twt.model.CommentReply;
import twt.model.Household;

public class CommentReplyTest {
	public static void commentReplyTest() throws ParseException{
		IHousehold housuhold=new HouseholdDao();
		   Household hd=new Household("王琦","13557213123",1,DateHandle.date("1989-02-18 56:45:00"),0);
		   int id1 =housuhold.insertHousehold(hd);
		   
		 IComment com=new CommentDao(); 
		 Comment comm=new Comment(hd,DateHandle.date("2001-02-19 56:45:00"),"楼道不够整洁");
		 int id2=com.insertComment(comm);
		 IAdmin admin=new AdminDao();
		 Admin ad=new Admin("王世","15557894251");
		 int id4=admin.insertAdmin(ad);
		 
		 ICommentReply comp=new CommentReplyDao();
		 CommentReply comply=new CommentReply(comm,ad,DateHandle.date("2001-02-19 56:45:00"),"已经多加了几个人清扫楼道，造成的困扰请见谅",id1);
		 int id3=comp.insertCommentReply(comply);
		 
		 List<CommentReply> commentreplys=comp.showCommentReply(5);
			for(CommentReply r:commentreplys) {
				System.out.println(r.getId());
			}
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		commentReplyTest();
	}

}

package twt.UnitTest;

import java.text.ParseException;
import java.util.List;

import twt.controller.DateHandle;
import twt.controller.dao.CommentDao;
import twt.controller.dao.HouseholdDao;
import twt.controller.dao.imp.IComment;
import twt.controller.dao.imp.IHousehold;
import twt.model.Car;
import twt.model.Comment;
import twt.model.Household;

public class CommentTest {
	public static void commentTest() throws ParseException {
		 IHousehold housuhold=new HouseholdDao();
		   Household hd=new Household("赵柳","15557213123",1,DateHandle.date("1987-02-18 56:45:00"),0);
		   int id1 =housuhold.insertHousehold(hd);
		IComment com=new CommentDao();
		int id=com.insertComment(new Comment(hd,DateHandle.date("2001-02-18 56:45:00"),"楼道的卫生做得不好"));
		  List<Comment> comments=com.showComment(3);
			for(Comment r:comments) {
				System.out.println(r.getId());
			}
	}
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		commentTest();
	}

}

package twt.controller.dao.imp;

import java.util.Date;
import java.util.List;

import twt.model.Car;
import twt.model.Comment;
import twt.model.CommentReply;
import twt.model.Household;

public interface IComment {
	//留言插入
   public int insertComment(Comment comment);
   //留言删除
   public boolean deleteComment(Comment comment,String content);
   //留言显示
   public List<Comment> showComment(int n);
}

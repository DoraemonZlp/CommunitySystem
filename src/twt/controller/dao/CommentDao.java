package twt.controller.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import twt.controller.MyGlobal;
import twt.controller.dao.imp.IComment;
import twt.model.Comment;
import twt.model.CommentReply;
import twt.model.Guard;
import twt.model.Household;

public class CommentDao implements IComment{
	public CommentDao() {
		MyGlobal.init();
	}
	//留言插入
	   public int insertComment(Comment comment){
		   MyGlobal.begintrans();
			MyGlobal.session.save(comment);
			MyGlobal.commit();
	    	return comment.getId();
	   }
	   //留言删除
	   public boolean deleteComment(Comment comment,String content){
		   MyGlobal.begintrans();
			MyGlobal.session.delete(MyGlobal.session.get(Comment.class, content));
			MyGlobal.commit();
			return true; 
	   }
	 //留言显示
	   public List<Comment> showComment(int n){
		   Query query = MyGlobal.session.createQuery("from Comment");
			//query.setParameter(0, n);
			List<Comment> comments;
			if(n>0) {
				comments =query.setMaxResults(n).list();//Hibernate可以使用Query.setMaxResults方法简单地设置需要查询的最大结果集
			}else {
				comments =query.list();
			}
			return comments;
	   }
}

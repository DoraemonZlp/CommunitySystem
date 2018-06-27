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
import twt.controller.dao.imp.ICommentReply;
import twt.model.Comment;
import twt.model.CommentReply;

public class CommentReplyDao implements ICommentReply {
	public CommentReplyDao() {
		MyGlobal.init();
	}
	//留言回复
    public int insertCommentReply(CommentReply commentReply){
    	 MyGlobal.begintrans();
			MyGlobal.session.save(commentReply);
			MyGlobal.commit();
	    	return commentReply.getId();
    }
    		//回复删除
    public boolean deleteCommentReply(CommentReply commentReply,String content){
    	  MyGlobal.begintrans();
			MyGlobal.session.delete(MyGlobal.session.get(CommentReply.class, content));
			MyGlobal.commit();
			return true; 
    }
    		//回复显示
    public List<CommentReply> showCommentReply(int n){
    	 Query query = MyGlobal.session.createQuery("from CommentReply");
			//query.setParameter(0, n);
			List<CommentReply> commentReplys;
			if(n>0) {
				commentReplys =query.setMaxResults(n).list();//Hibernate可以使用Query.setMaxResults方法简单地设置需要查询的最大结果集
			}else {
				commentReplys =query.list();
			}
			return commentReplys;
    }
}

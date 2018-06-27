package twt.controller.dao.imp;

import java.util.Date;
import java.util.List;

import twt.model.Comment;
import twt.model.CommentReply;

public interface ICommentReply { 
			//留言回复
    public int insertCommentReply(CommentReply commentReply);
    		//回复删除
    public boolean deleteCommentReply(CommentReply commentReply,String content);
    		//回复显示
    public List<CommentReply> showCommentReply(int n);
}

package twt.controller.dao.imp;

import java.util.Date;

import twt.model.Comment;

public interface ICommentReply {
public boolean insertCommentReply(int id, Comment comment, int commentid, int household,Date time, String content);

}

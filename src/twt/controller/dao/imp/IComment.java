package twt.controller.dao.imp;

import java.util.Date;

import twt.model.CommentReply;
import twt.model.Household;

public interface IComment {
   public boolean insertComment(Integer id, Household household, Date time, String content, CommentReply commentReply);
}

package twt.controller.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.opensymphony.xwork2.Action;

import twt.model.CommentReply;
import twt.model.Household;

public class CmmentAction implements Action{
	private Integer id;
	private Household household;
	private Date time;
	private String content;
	private CommentReply commentReply;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "household", nullable = false)
	public Household getHousehold() {
		return this.household;
	}

	public void setHousehold(Household household) {
		this.household = household;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "content", nullable = false, length = 2048)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "comment")
	public CommentReply getCommentReply() {
		return this.commentReply;
	}

	public void setCommentReply(CommentReply commentReply) {
		this.commentReply = commentReply;
	}
  public String execute()throws Exception{
	  return "seccess";
  }
}

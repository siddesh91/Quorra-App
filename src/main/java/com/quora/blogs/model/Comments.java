package com.quora.blogs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long commentid;
	
	@Column(name="comments", nullable = false)	
	private String comments;
	
	//@JoinColumn(name = "user_question_id")	
	@ManyToOne(targetEntity = Question.class)
	private long questionid;
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(long commentid, String comments, long questionid) {
		super();
		this.commentid = commentid;
		this.comments = comments;
		this.questionid = questionid;
	}


	public long getCommentid() {
		return commentid;
	}

	public void setCommentid(long commentid) {
		this.commentid = commentid;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	public long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(long questionid) {
		this.questionid = questionid;
	}
	
	

}

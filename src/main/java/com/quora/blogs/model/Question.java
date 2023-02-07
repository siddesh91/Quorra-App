package com.quora.blogs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserQuestion")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "question", nullable = false)
	private String question;
	
	//@ManyToOne
	//@JoinColumn(name="cid")
	@Column(name = "user_id", nullable = false)
	private long userid;
	
	@OneToMany(mappedBy = "questionid", cascade = CascadeType.ALL)
	private List<Comments> comments = new ArrayList<>();
	
	
	
	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public Question() {
		// TODO Auto-generated constructor stub
	}

	
	

	public Question(long id, String question, long userid, List<Comments> comments) {
		this.id = id;
		this.question = question;
		this.userid = userid;
		this.comments = comments;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	//@Column(name = "user_id", nullable = false)
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", userid=" + userid + "]";
	}
	
	

}

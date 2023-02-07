package com.quora.blogs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quora.blogs.model.Comments;
import com.quora.blogs.model.Question;
import com.quora.blogs.repositories.CommentRepository;
import com.quora.blogs.repositories.QuestionRepository;

@Service
public class ReportServiceImpl implements IReport{
	
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public List<Map<String,String>> getallQuestion() {
		
		List<Map<String,String>> inventory = new ArrayList<>();
		
		Map<String, String> commentSet = new HashMap<>();
		
		
		
		List<Question> questionset = questionRepository.findAll();
		
		String userQuestion;
		String qstAnswer;
		
		for (Question question : questionset) {
			long questionid = question.getId();
			userQuestion = question.getQuestion();
			Comments usercomment = commentRepository.findByquestionid(questionid);
			qstAnswer = usercomment.getComments();
			commentSet.put(userQuestion, qstAnswer);
			inventory.add(commentSet);
			
		}

		return inventory;
	}
	
	

}

package com.quora.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quora.blogs.model.Question;
import com.quora.blogs.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	// -- Method for saving the user
	public Question save(Question question) {
		return questionRepository.save(question);
	}

	// -- Method for fetching all users
	public List<Question> getAllUsers() {
		return (List<Question>) questionRepository.findAll();
	}

	// -- Method for fetching user by id
	public Question getQuestionById(Long id) {
		return questionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No Question found for the following id : " + id));
	}

	// -- Method for deleting user by id
	public void deleteQuestionById(Long questionId) {
		Question existingQuestion = questionRepository.findById(questionId).get();
		questionRepository.delete(existingQuestion);
	}

	public Question updateUser(Question question, Long id) {
		Question existingQuestion = questionRepository.findById(id).get();
		existingQuestion.setQuestion(question.getQuestion());
		existingQuestion.setId(question.getId());
		existingQuestion.setUserid(question.getUserid());
		return questionRepository.save(existingQuestion);
	}

}

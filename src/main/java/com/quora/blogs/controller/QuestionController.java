package com.quora.blogs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quora.blogs.model.Question;
import com.quora.blogs.repositories.QuestionRepository;

@RestController
@RequestMapping("api/v1")
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepository;

	@PostMapping("addQuestion")
	public Question createQuestion(@RequestBody Question question) {
		return questionRepository.save(question);
	}

	@GetMapping("findbyUser/{id}")
	public ResponseEntity<List<Question>> getQuestionById(@PathVariable("id") long id) {
		List<Question> questionData = questionRepository.findByuserid(id);
		if (questionData.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(questionData, HttpStatus.OK);
	}
	
	

}

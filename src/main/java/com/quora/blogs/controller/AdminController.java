package com.quora.blogs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quora.blogs.model.Question;
import com.quora.blogs.repositories.CommentRepository;
import com.quora.blogs.repositories.QuestionRepository;
//import com.quora.blogs.service.IReport;


@RestController
@RequestMapping("api/v1/report")
public class AdminController {
	
	/*@Autowired
	IReport reportService;

	
	@GetMapping("/allquestion")
	public ResponseEntity<List<Map<String,String>>> getallQuestion() {
		
		
		reportService.
		if (questionData.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(questionData, HttpStatus.OK);
	}*/

}

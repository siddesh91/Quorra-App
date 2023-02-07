package com.quora.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quora.blogs.model.Comments;
import com.quora.blogs.service.CommentServiceImpl;


@RestController
@RequestMapping("api/v1")
public class CommentController {
	
	@Autowired
	CommentServiceImpl commentService;
	
	@PostMapping("answerQuestion")
	public void addComment(@RequestBody Comments comment) {
		commentService.addComment(comment);
		
	}
	

}

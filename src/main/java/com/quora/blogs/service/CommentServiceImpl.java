package com.quora.blogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quora.blogs.model.Comments;
import com.quora.blogs.repositories.CommentRepository;

@Service
public class CommentServiceImpl {
	
	@Autowired
	CommentRepository commentRepo;


	public void addComment(Comments comment) {
		commentRepo.save(comment);

	}

}

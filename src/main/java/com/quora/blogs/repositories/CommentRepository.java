package com.quora.blogs.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quora.blogs.model.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
	
	Comments findByquestionid(Long questionid);

}

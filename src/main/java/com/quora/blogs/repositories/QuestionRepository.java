package com.quora.blogs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quora.blogs.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	public List<Question> findByuserid(Long id);


}

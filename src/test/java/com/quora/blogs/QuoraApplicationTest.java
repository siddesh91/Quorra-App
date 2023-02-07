package com.quora.blogs;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.quora.blogs.controller.QuestionController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class QuoraApplicationTest {
	
	@Autowired
	QuestionController questionController;

	@Test
	void test() {
		Assertions.assertThat(questionController).isNot(null);
	}

}

package com.quora.blogs.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.quora.blogs.model.User;

@DataJpaTest
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@BeforeEach
	void init() {

	}

	@Test
	void save() {
		//Arrange
		User user = new User();
		user.setEmailId("test@test.com");
		user.setFirstName("Tom");
		user.setLastName("Jerry");
		
		
		
		//Act
		User newUser = userRepository.save(user);
		
		//Assert
		assertNotNull(newUser);
		assertThat(newUser.getId()).isNotEqualTo(null);
	}
	
	@Test
	void getAllUsers() {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
	}

}

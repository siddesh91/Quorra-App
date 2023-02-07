package com.quora.blogs.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quora.blogs.model.User;
import com.quora.blogs.service.UserServiceImpl;


//@WebMvcTest(controllers = UserController.class, useDefaultFilters = false)
@WebMvcTest
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserServiceImpl quorraUserSvc;

	@Autowired
	private ObjectMapper objectMapper;

	private User user1;
	private User user2;

	@BeforeEach
	void init() {
		user1 = new User();
		user1.setId(1L);
		user1.setEmailId("john.dove@quorra.com");
		user1.setFirstName("John");
		user1.setLastName("Dove");

		user2 = new User();
		user2.setId(2L);
		user2.setEmailId("ron.ray@quorra.com");
		user2.setFirstName("Ron");
		user2.setLastName("Ray");
	}
	
	@Test
	void shouldFetchAllUsers()throws Exception
	{
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		
		when(quorraUserSvc.getAllUsers()).thenReturn(userList);
		
		this.mockMvc.perform(get("/users"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.size()", is(userList.size())));
		
	}

	@Test
	void shouldCreateNewUser() throws Exception{
		
		when(quorraUserSvc.save(any(User.class))).thenReturn(user1);
		
		this.mockMvc.perform(post("/newuser"))
		//.contentType(MediaType.APPLICATION_JSON)
		//.content(objectMapper.writeValueAsString(user1)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.firstname", is(user1.getFirstName())))
		.andExpect(jsonPath("$.lastname", is(user1.getLastName())))
		.andExpect(jsonPath("$.emailid", is(user1.getEmailId())));		
	}
	
	
	
	
}

package com.quora.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quora.blogs.model.User;
import com.quora.blogs.repositories.UserRepository;
import com.quora.blogs.service.UserServiceImpl;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	// --- Create a new user
	@PostMapping("/newuser")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser (@RequestBody User user) {		
		return userService.save(user);
	}		
	
	// --- Get all users
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	
	//-- Get user by id
	@GetMapping("/user/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User getUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	// --- Delete user by id
	@DeleteMapping("/user/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUserEntity(id);
	}
	
	// --- Update user by id
	@PutMapping("/user/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User update(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(user,id);
	}

}

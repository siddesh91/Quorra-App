package com.quora.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quora.blogs.model.User;
import com.quora.blogs.repositories.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	// -- Method for saving the user
	public User save(User user) {
		return userRepository.save(user);
	}

	// -- Method for fetching all users
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	// -- Method for fetching user by id
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found for the following id : " + id));
	}

	// -- Method for deleting user by id
	public void deleteUserEntity(Long userId) {
		User existingUser = userRepository.findById(userId).get();
		userRepository.delete(existingUser);
	}

	public User updateUser(User user, Long id) {
		User existingUser = userRepository.findById(id).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmailId(user.getEmailId());
		return userRepository.save(existingUser);
	}

}

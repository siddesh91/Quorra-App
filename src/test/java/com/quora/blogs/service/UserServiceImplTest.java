package com.quora.blogs.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.quora.blogs.model.User;
import com.quora.blogs.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl userServc;
	
	@Mock
	private UserRepository userRepo;
	
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
	@DisplayName("Should save user to database")
	void save() {
		when(userRepo.save(any(User.class))).thenReturn(user1);
		
		User newUser = userServc.save(user1);
		
		assertNotNull(newUser);
		assertThat(newUser.getFirstName()).isEqualTo("John");
	}
	
	@Test
	@DisplayName("Get all the users from database")
	void getAllUsers() {
		
		List<User> userLists = new ArrayList<>();
		userLists.add(user1);
		userLists.add(user2);
		
		when(userRepo.findAll()).thenReturn(userLists);
		
		List<User> allusers = userServc.getAllUsers();
		
		assertEquals(2, allusers.size());
		assertNotNull(allusers);
	}
	
	@Test
	@DisplayName("Get users from database by id")
	void getUserByid() {
		
		when(userRepo.findById(anyLong())).thenReturn(Optional.of(user1));
		
		User existingUser = userServc.getUserById(user1.getId());
		
		assertNotNull(existingUser);
		assertThat(existingUser.getId()).isNotEqualTo(null);
	}
	
	@Test
	@DisplayName("Delete user from database")
	void deleteUser() {
		Long userId = 1L;
		
		when(userRepo.findById(anyLong())).thenReturn(Optional.of(user1));
		doNothing().when(userRepo).delete(any(User.class));
		
		userServc.deleteUserEntity(userId);
		
		verify(userRepo, times(1)).delete(user1);
	}
	
	@Test
	@DisplayName("Update user from database")
	void updateUser() {
		
		when(userRepo.findById(anyLong())).thenReturn(Optional.of(user2));
		
		when(userRepo.save(any(User.class))).thenReturn(user2);
		user2.setFirstName("Tim");
		User existingUser = userServc.updateUser(user2, user2.getId());
		
		assertNotNull(existingUser);
		assertEquals("Tim", existingUser.getFirstName());
		
		
	}
	

}

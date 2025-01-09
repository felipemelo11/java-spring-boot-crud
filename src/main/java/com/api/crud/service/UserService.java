package com.api.crud.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.crud.model.User;
import com.api.crud.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User createUser(User user) {

		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(String userId) {
		
		return userRepository.findById(UUID.fromString(userId));
	}

	public List<User> listUsers() {
		
		return userRepository.findAll();
	}
	
	public void updateUserById(String userId, User u) {
		UUID id = UUID.fromString(userId);
		
		Optional<User> userEntity = userRepository.findById(id);
		
		if (userEntity.isPresent()) {
			User user = userEntity.get();
			
			if (u.getUsername() != null) {
				user.setUsername(u.getUsername());
			}
			
			if (u.getPassword() != null) {
				user.setPassword(u.getPassword());
			}
			
			userRepository.save(user);
		}
	}
	
	public void deleteById(String userId) {
		UUID id = UUID.fromString(userId);
	
		boolean userExists = userRepository.existsById(id);
	
		if (userExists) {
			userRepository.deleteById(id);
		}
	}
}

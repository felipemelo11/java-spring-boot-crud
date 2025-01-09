package com.api.crud.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.model.User;
import com.api.crud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userId = userService.createUser(user);
		
		return ResponseEntity.created(URI.create("/users/" + userId.getUserId().toString())).build();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
		Optional<User> user = userService.getUserById(userId);
		
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<User>> listUsers() {
		List<User> users = userService.listUsers();
		
		return ResponseEntity.ok(users);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId, @RequestBody User user) {
		userService.updateUserById(userId, user);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId) {
		userService.deleteById(userId);
		
		return ResponseEntity.noContent().build();
	}
}

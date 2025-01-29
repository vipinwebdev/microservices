package com.vip.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vip.user.entity.User;


public interface UserController {

	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user);
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<Object> getAllUsers();
	
	@GetMapping("getUser/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId);
}

package com.vip.user.controller.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vip.user.controller.UserController;
import com.vip.user.entity.User;
import com.vip.user.service.UserService;

@RestController
@RequestMapping(value = "/users",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService userService;
	
	@Override
	public ResponseEntity<User> createUser(User user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		User saveUser = userService.saveUser(user);
		return ResponseEntity.ok(saveUser);
	}

	@Override
	public ResponseEntity<Object> getAllUsers() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

	@Override
	public ResponseEntity<User> getUser(String userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

}

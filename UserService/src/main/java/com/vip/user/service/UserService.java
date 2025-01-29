package com.vip.user.service;

import java.util.List;

import com.vip.user.entity.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
}

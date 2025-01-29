package com.vip.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vip.user.entity.User;
import com.vip.user.repository.UserRepository;
import com.vip.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		Optional<User> findById = userRepository.findById(userId);
		
		if(findById.isPresent())
			return findById.get();
		else
			return null;
	}

}

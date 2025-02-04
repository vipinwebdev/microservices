package com.vip.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vip.user.entity.Ratings;
import com.vip.user.entity.User;
import com.vip.user.repository.UserRepository;
import com.vip.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String userId) {
		Optional<User> findById = userRepository.findById(userId);
		
		if(findById.isPresent()) {
			 User user = findById.get();
			 List<Ratings> ratings = restTemplate.getForObject("http://localhost:7073/ratings/getRatingByUser?userId="+userId, ArrayList.class);
			 user.setRatings(ratings);
			 return user;
		}
		else
			return null;
	}

}

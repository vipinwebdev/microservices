package com.vip.user.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vip.user.entity.Hotel;
import com.vip.user.entity.Ratings;
import com.vip.user.entity.User;
import com.vip.user.external.services.HotelService;
import com.vip.user.external.services.RatingService;
import com.vip.user.repository.UserRepository;
import com.vip.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	RatingService ratingService;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUsers = userRepository.findAll();
		
		List<User> users = allUsers.stream().map(user -> {
			/*
			 * Ratings[] ratings = restTemplate.getForObject(
			 * "http://RATING-SERVICE/ratings/getRatingByUser?userId="+user.getUserId(),
			 * Ratings[].class); List<Ratings> ratingList = Arrays.asList(ratings);
			 */
			List<Ratings> ratingsByUser = ratingService.getRatingsByUser(user.getUserId());
			 List<Ratings> list = ratingsByUser.stream().map(rating ->{
				/*
				 * ResponseEntity<Hotel> entity =
				 * restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/getHotel/"+rating.
				 * getHotelId(), Hotel.class); rating.setHotel(entity.getBody());
				 */
				 
				 Hotel hotel = hotelService.getHotel(rating.getHotelId());
				 rating.setHotel(hotel);
				return  rating;
			 }).toList();
			 user.setRatings(list);
			 return user;
		}).toList();
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		Optional<User> findById = userRepository.findById(userId);
		
		if(findById.isPresent()) {
			 User user = findById.get();
				/*
				 * Ratings[] ratings = restTemplate.getForObject(
				 * "http://RATING-SERVICE/ratings/getRatingByUser?userId="+userId,
				 * Ratings[].class); List<Ratings> ratingList = Arrays.asList(ratings);
				 */
			 
			 List<Ratings> ratingsByUser = ratingService.getRatingsByUser(userId);
			 List<Ratings> list = ratingsByUser.stream().map(rating ->{
					/*
					 * ResponseEntity<Hotel> entity =
					 * restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/getHotel/"+rating.
					 * getHotelId(), Hotel.class); rating.setHotel(entity.getBody());
					 */
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				return  rating;
			 }).toList();
			 user.setRatings(list);
			 return user;
		}
		else
			return null;
	}

}

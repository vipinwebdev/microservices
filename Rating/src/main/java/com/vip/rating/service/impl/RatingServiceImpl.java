package com.vip.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vip.rating.entity.Ratings;
import com.vip.rating.repositories.RatingRepository;
import com.vip.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Ratings saveRating(Ratings reating) {
		String reatingId = UUID.randomUUID().toString();
		reating.setRatingId(reatingId);
		return ratingRepository.save(reating);
	}

	@Override
	public List<Ratings> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Ratings> getRatingByUser(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Ratings> getRatingByhotel(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}


}

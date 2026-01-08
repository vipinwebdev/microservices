package com.vip.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vip.rating.entity.Ratings;

public interface RatingRepository extends MongoRepository<Ratings, String> {

	List<Ratings> findByUserId(String userId);
	
	List<Ratings> findByHotelId(String hotelId);
}

package com.vip.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vip.rating.entity.Ratings;

public interface RatingRepository extends JpaRepository<Ratings, String> {

	List<Ratings> findByUserId(String userId);
	
	List<Ratings> findByHotelId(String hotelId);
}

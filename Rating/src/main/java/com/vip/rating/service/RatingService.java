package com.vip.rating.service;

import java.util.List;

import com.vip.rating.entity.Ratings;

public interface RatingService {

	public Ratings saveRating(Ratings hotel);
	
	public List<Ratings> getAllRatings();
	
	public List<Ratings> getRatingByUser(String userId);
	
	public List<Ratings> getRatingByhotel(String hotelId);
}

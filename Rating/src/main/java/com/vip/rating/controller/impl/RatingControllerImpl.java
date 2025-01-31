package com.vip.rating.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vip.rating.controller.RatingController;
import com.vip.rating.entity.Ratings;
import com.vip.rating.service.RatingService;


@RestController
@RequestMapping(value="/ratings",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class RatingControllerImpl implements RatingController {
	
	@Autowired
	private RatingService ratingService;

	@Override
	public ResponseEntity<Object> crateRating(Ratings hotel) {
		Ratings saveHotel = ratingService.saveRating(hotel);
		return ResponseEntity.ok(saveHotel);
	}

	@Override
	public ResponseEntity<Object> getAllRatings() {
		return ResponseEntity.ok(ratingService.getAllRatings());
	}

	@Override
	public ResponseEntity<Object> getRatingByUser(String userId) {
		return ResponseEntity.ok(ratingService.getRatingByUser(userId));
	}

	@Override
	public ResponseEntity<Object> getRatingByHotel(String hotelId) {
		return ResponseEntity.ok(ratingService.getRatingByhotel(hotelId));
	}

}

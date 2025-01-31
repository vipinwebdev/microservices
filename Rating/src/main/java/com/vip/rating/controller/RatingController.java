package com.vip.rating.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vip.rating.entity.Ratings;


public interface RatingController {

	@PostMapping(value="/save")
	public ResponseEntity<Object> crateRating(@RequestBody Ratings rating);
	
	@GetMapping(value="/getAllRatings")
	public ResponseEntity<Object> getAllRatings();
	
	@GetMapping("/getRatingByUser")
	public ResponseEntity<Object> getRatingByUser(@RequestParam String userId);
	
	@GetMapping("/getRatingByHotel")
	public ResponseEntity<Object> getRatingByHotel(@RequestParam String hotelId);
}

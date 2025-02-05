package com.vip.hotel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vip.hotel.entity.Hotel;


public interface HotelController {

	@PostMapping(value="/save")
	public ResponseEntity<Object> crateHotel(@RequestBody Hotel hotel);
	
	@GetMapping(value="/getAllHotels")
	public ResponseEntity<Object> getAllHotels();
	
	@GetMapping("/getHotel/{id}")
	public ResponseEntity<Object> getHotel(@PathVariable String id);
}

package com.vip.hotel.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vip.hotel.controller.HotelController;
import com.vip.hotel.entity.Hotel;
import com.vip.hotel.service.HotelService;


@RestController
@RequestMapping(value="/hotels",produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class HotelControllerImpl implements HotelController {
	
	@Autowired
	private HotelService hotelService;

	@Override
	public ResponseEntity<Object> crateHotel(Hotel hotel) {
		Hotel saveHotel = hotelService.saveHotel(hotel);
		return ResponseEntity.ok(saveHotel);
	}

	@Override
	public ResponseEntity<Object> getAllHotels() {
		return ResponseEntity.ok(hotelService.getAllHotels());
	}

	@Override
	public ResponseEntity<Object> getHotel(String id) {
		return ResponseEntity.ok(hotelService.getHotel(id));
	}

}

package com.vip.hotel.service;

import java.util.List;

import com.vip.hotel.entity.Hotel;

public interface HotelService {

	public Hotel saveHotel(Hotel hotel);
	
	public List<Hotel> getAllHotels();
	
	public Hotel getHotel(String id);
}

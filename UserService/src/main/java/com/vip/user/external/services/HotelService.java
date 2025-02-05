package com.vip.user.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vip.user.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
@Service
public interface HotelService {

	@GetMapping("/hotels/getHotel/{id}")
	Hotel getHotel(@PathVariable("id") String hotelId);
}

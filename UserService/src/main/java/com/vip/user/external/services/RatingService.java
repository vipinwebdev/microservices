package com.vip.user.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vip.user.entity.Ratings;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ratings/getRatingByUser")
	List<Ratings> getRatingsByUser(@RequestParam String userId);

}

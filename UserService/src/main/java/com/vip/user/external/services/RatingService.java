package com.vip.user.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vip.user.entity.Ratings;

@FeignClient(name = "RATING-SERVICE")
@Service
public interface RatingService {

	@GetMapping("/ratings/getRatingByUser")
	List<Ratings> getRatingsByUser(@RequestParam String userId);
}

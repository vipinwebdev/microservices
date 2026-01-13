package com.vip.user.external.services;

import com.vip.user.entity.Ratings;
import com.vip.user.entity.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@Slf4j
public class RatingClientService {

    @Autowired
    private RatingService ratingService;

    int x = 1;

//    @CircuitBreaker(name = "ratingsByUser", fallbackMethod = "fallbackRatings")
//    @Retry(name = "ratingHotelService", fallbackMethod = "fallbackRatings")
    @RateLimiter(name = "userService", fallbackMethod = "rateLimitFallback")
    public List<Ratings> getRatings(String userId) {
        log.info("Retry: {}",x);
        x++;
        return ratingService.getRatingsByUser(userId);
    }

    public List<Ratings> fallbackRatings(String userId, Throwable ex) {
        Ratings ratings = new Ratings();
        ratings.setRating(0);
        ratings.setFeedback("Ratings not available currently");
        ratings.setHotel(null);
        return List.of(ratings);
    }

    public List<Ratings> rateLimitFallback(String userId, Throwable ex) {
        Ratings ratings = new Ratings();
        ratings.setRating(0);
        ratings.setFeedback("Too many requests. Please try again later.");
        ratings.setHotel(null);

        return List.of(ratings);
    }

//    public List<Ratings> rateLimitFallback(String userId, Throwable ex) {
//        throw new ResponseStatusException(
//                HttpStatus.TOO_MANY_REQUESTS,
//                "Too many requests. Please try again later."
//        );
//    }
}

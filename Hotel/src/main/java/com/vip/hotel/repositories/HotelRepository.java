package com.vip.hotel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vip.hotel.entity.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}

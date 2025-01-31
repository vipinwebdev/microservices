package com.vip.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vip.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}

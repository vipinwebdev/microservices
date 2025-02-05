package com.vip.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ratings {

	private String ratingId;
	private String userId;
	private String hotelId;
	private String feedback;
	private int rating;
	private Hotel hotel;
}

package com.vip.rating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Document(collection = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ratings {
	
	@Id
	@Field(name = "ID")
	private String ratingId;
	
	@Field(name = "USER_ID")
	private String userId;
	
	@Field(name = "HOTEL_ID")
	private String hotelId;
	
	@Field(name = "FEEDBACK")
	private String feedback;
	
	@Field(name = "RATING")
	private int rating;
	
}

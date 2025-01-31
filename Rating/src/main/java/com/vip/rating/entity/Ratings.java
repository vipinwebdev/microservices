package com.vip.rating.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ratings {
	
	@Id
	@Column(name = "ID")
	private String ratingId;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "HOTEL_ID")
	private String hotelId;
	
	@Column(name = "FEEDBACK")
	private String feedback;
	
	@Column(name = "RATING")
	private int rating;
	
}

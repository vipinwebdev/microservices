package com.vip.hotel.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel {

	@Id
	@Field(name = "ID")
	private String id;
	
	@Field(name = "NAME")
	private String name;
	
	@Field(name = "LOCATION")
	private String location;
	
	@Field(name = "ABOUT")
	private String about;
	
}

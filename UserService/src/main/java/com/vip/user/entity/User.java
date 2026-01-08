package com.vip.user.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.lang.NonNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Document(collection= "users")
@Getter
@Setter
@ToString
public class User {

	@Id
	@Field(name = "ID")
	private String userId;
	
	@Field(name = "NAME")
	@Indexed(unique = true)
    @NonNull
	private String name;
	
	@Field(name = "EMAIL")
	@Indexed(unique = true)
	private String email;
	
	@Field(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Ratings> ratings = new ArrayList<>();
}

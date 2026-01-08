package com.vip.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vip.user.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

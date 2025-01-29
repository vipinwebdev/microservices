package com.vip.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vip.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

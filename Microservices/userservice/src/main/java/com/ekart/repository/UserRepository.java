package com.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}

package com.ekart.service;

import java.util.List;

import com.ekart.entity.User;

public interface UserService {
	
	User addUser(User user);
	List<User> getAllUsers();
	User updateUserById(int id, User user);
	String deleteUserById(int id);
	User getUserById(int id);
}

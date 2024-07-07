package com.ekart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.entity.User;
import com.ekart.exception.AgeIsNotValidException;
import com.ekart.exception.IdNotFoundException;
import com.ekart.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		if(user.getAge()<0)
		{
			throw new AgeIsNotValidException("Enter Age in Positive.");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User updateUserById(int id, User user) {
		// TODO Auto-generated method stub
		Optional<User> use =  userRepository.findById(id);
		if(use.isPresent())
		{
			return userRepository.save(user);
		}
		else {
			throw new IdNotFoundException("No user with this id is found.");
		}
	}

	@Override
	public String deleteUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> use =  userRepository.findById(id);
		if(use.isPresent())
		{
			userRepository.deleteById(id);
			return "User deleted successfully.";
		}
		else {
			throw new IdNotFoundException("No user with this id is found.");
		}
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> use = userRepository.findById(id);
		if(use.isPresent())
		{
			
			return use.get();
		}
		else
		{
			throw new IdNotFoundException("No user with this id is found.");
		}
	}

	
}

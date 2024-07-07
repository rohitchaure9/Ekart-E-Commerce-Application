package com.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.entity.User;
import com.ekart.exception.AgeIsNotValidException;
import com.ekart.exception.IdNotFoundException;
import com.ekart.service.UserService;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/api/ekart/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/add")
	ResponseEntity<User> adduser(@RequestBody User user){
		return new ResponseEntity<User> (userService.addUser(user),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>> (userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<User> getUserById(@PathVariable int id){
		return new ResponseEntity<User> (userService.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<User> updateProductById(@PathVariable int id, @RequestBody User user){
		return new ResponseEntity<User> (userService.updateUserById(id, user), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<String> deleteProductById(@PathVariable int id){
		return new ResponseEntity<String> (userService.deleteUserById(id),HttpStatus.OK);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<String> myIdException(IdNotFoundException exception){
		return new ResponseEntity<String> (exception.getMsg(),HttpStatus.NOT_FOUND);
	} 
	
	@ExceptionHandler(AgeIsNotValidException.class)
	ResponseEntity<String> myAgeException(AgeIsNotValidException exception){
		return new ResponseEntity<String> (exception.getMsg(),HttpStatus.BAD_REQUEST);
	}
	
//	@PostMapping("/kart/{userId}/{prodId}")
//	ResponseEntity<Kart> addProductToKart(@PathVariable int userId, @PathVariable int prodId){
//		return new ResponseEntity<Kart> (kartFeignClient.addProductToKart(userId, prodId),HttpStatus.OK);
//	}
//	
//	@GetMapping("/kart/user/{userId}")
//	ResponseEntity<List<Kart>> getKartProductsByUserId(@PathVariable int userId){
//		return new ResponseEntity<List<Kart>> (kartFeignClient.getKartProductsByUserId(userId),HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/kart/{objId}")
//	ResponseEntity<String> deleteProductFromKart(@PathVariable ObjectId objId){
//		return new ResponseEntity<String> (kartFeignClient.deleteProductFromKart(objId),HttpStatus.OK);
//	}
//	
//	@PostMapping("/wishList/{userId}/{prodId}")
//	ResponseEntity<WishList> addProductToWishList(@PathVariable int userId, @PathVariable int prodId){
//		return new ResponseEntity<WishList> (wishListFeignClient.addProductToWishList(userId, prodId),HttpStatus.OK);
//	}
//	
//	@GetMapping("/wishList/user/{userId}")
//	ResponseEntity<List<WishList>> getWishListProductsByUserId(@PathVariable int userId){
//		return new ResponseEntity<List<WishList>> (wishListFeignClient.getWishListProductsByUserId(userId),HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/wishList/{objId}")
//	ResponseEntity<String> deleteProductFromWishList(@PathVariable ObjectId objId){
//		return new ResponseEntity<String> (wishListFeignClient.deleteProductFromWishList(objId),HttpStatus.OK);
//	}
 }

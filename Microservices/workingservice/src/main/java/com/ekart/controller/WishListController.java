package com.ekart.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.entity.WishList;
import com.ekart.service.WishListService;

@CrossOrigin
@RestController
@RequestMapping("/api/ekart/working")
public class WishListController {
	
	@Autowired
	WishListService wishListService;
	
	@PostMapping("/wishList/{userId}/{prodId}")
	ResponseEntity<WishList> addProductToWishList(@PathVariable int userId, @PathVariable int prodId){
		return new ResponseEntity<WishList> (wishListService.addProductToWishList(userId, prodId),HttpStatus.OK);
	}
	
	@GetMapping("/wishList/products")
	ResponseEntity<List<WishList>> getAllWishListProducts(){
		return new ResponseEntity<List<WishList>> (wishListService.getAllWishListProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/wishList/user/{userId}")
	ResponseEntity<List<WishList>> getAllWishListProductsByUserId(@PathVariable int userId){
		return new ResponseEntity<List<WishList>> (wishListService.getWishListProductsByUserId(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/wishList/{objId}")
	ResponseEntity<String> deleteProductFromWishList(@PathVariable ObjectId objId){
		return new ResponseEntity<String> (wishListService.deleteProductFromWishList(objId),HttpStatus.OK);
	}
	
	@DeleteMapping("wishList/user/{userId}/{prodId}")
	ResponseEntity<String> deleteWLProductByProdUserId(@PathVariable int userId, @PathVariable int prodId){
		return new ResponseEntity<String> (wishListService.deleteWLProductByProdUserId(userId, prodId),HttpStatus.OK);
	}

}

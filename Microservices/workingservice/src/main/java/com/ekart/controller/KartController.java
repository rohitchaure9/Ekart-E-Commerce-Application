package com.ekart.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.entity.Kart;
import com.ekart.service.KartService;

@CrossOrigin
@RestController
@RequestMapping("/api/ekart/working")
public class KartController {
	
	@Autowired
	KartService kartService;
	
	@PostMapping("/kart/{userId}/{prodId}")
	ResponseEntity<Kart> addProductToKart(@PathVariable int userId, @PathVariable int prodId){
		return new ResponseEntity<Kart> (kartService.addProductToKart(userId, prodId),HttpStatus.OK);
	}
	
	@GetMapping("/kart/products")
	ResponseEntity<List<Kart>> getAllKartProducts(){
		return new ResponseEntity<List<Kart>> (kartService.getAllKartProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/kart/user/{userId}")
	ResponseEntity<List<Kart>> getAllKartProductsByUserId(@PathVariable int userId){
		return new ResponseEntity<List<Kart>> (kartService.getKartProductsByUserId(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/kart/{objId}")
	ResponseEntity<String> deleteProductFromKart(@PathVariable ObjectId objId){
		return new ResponseEntity<String> (kartService.deleteProductFromKart(objId),HttpStatus.OK);
	}
	
	@DeleteMapping("/kart/user/{userId}")
	ResponseEntity<String> deleteProductsByUserId(@PathVariable int userId){
		return new ResponseEntity<String>(kartService.deleteKartProductsByUserId(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/kart/user/{userId}/{prodId}")
	ResponseEntity<String> deleteProductByProdUserId(@PathVariable int userId, @PathVariable int prodId){
		return new ResponseEntity<String> (kartService.deleteProductByProdUserId(userId, prodId),HttpStatus.OK);
	}
	
	@PostMapping("/kart/increment/{userId}/{prodId}")
	ResponseEntity<String> incrementQuantity(@PathVariable int userId, @PathVariable int prodId){
		return new ResponseEntity<String> (kartService.incrementQuantity(userId, prodId), HttpStatus.OK);
	}
	
	@PostMapping("/kart/decrement/{userId}/{prodId}")
	ResponseEntity<String> decrementQuantity(@PathVariable int userId, @PathVariable int prodId){
		return new ResponseEntity<String> (kartService.decrementQuantity(userId, prodId), HttpStatus.OK);
	}
}

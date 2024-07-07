package com.ekart.controller;

import java.util.List;

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

import com.ekart.entity.Order;
import com.ekart.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api/ekart/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/user/{userId}")
	ResponseEntity<String> placeOrder(@PathVariable int userId){
		return new ResponseEntity<String> (orderService.placeOrder(userId),HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable int userId){
		return new ResponseEntity<List<Order>> (orderService.getAllOrdersByUserId(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}/{prodId}")
	ResponseEntity<String> deleteOrder(@PathVariable int userId, @PathVariable int prodId){
		return new ResponseEntity<String> (orderService.cancelOrder(userId,prodId),HttpStatus.OK);
	}
}

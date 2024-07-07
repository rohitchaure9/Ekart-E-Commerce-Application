package com.ekart.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ekart.entity.Order;

public interface OrderRepository extends MongoRepository<Order, ObjectId>{
	@Query("{'userId':?0}")
	List<Order> getOrdersByUserId(int userId);
	
}

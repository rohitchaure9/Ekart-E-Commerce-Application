package com.ekart.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ekart.entity.WishList;

public interface WishListRepository extends MongoRepository<WishList, ObjectId>{
	
	@Query("{'userId':?0}")
	List<WishList> getWishListProductsByUserId(int userId);
}

package com.ekart.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ekart.entity.Kart;

public interface KartRepository extends MongoRepository<Kart, ObjectId>{
	
	@Query("{'userId':?0}")
	List<Kart> getKartProductsByUserId(int userId);
	
	@Query(value="{'userId':?0}", delete = true)
	String deleteKartProductsByUserId(int userId);
}

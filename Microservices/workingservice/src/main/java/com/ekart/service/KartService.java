package com.ekart.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ekart.entity.Kart;

public interface KartService {
	Kart addProductToKart(int userId, int prodId);
	List<Kart> getAllKartProducts();
	List<Kart> getKartProductsByUserId(int userId);
	String deleteProductFromKart(ObjectId id);
	String deleteKartProductsByUserId(int userId);
	String deleteProductByProdUserId(int userId, int prodId);
	String incrementQuantity(int userId, int prodId);
	String decrementQuantity(int userId, int prodId);
}

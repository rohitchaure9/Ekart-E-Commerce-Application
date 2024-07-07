package com.ekart.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ekart.entity.WishList;

public interface WishListService {
	WishList addProductToWishList(int userId, int prodId);
	List<WishList> getAllWishListProducts();
	List<WishList> getWishListProductsByUserId(int userId);
	String deleteProductFromWishList(ObjectId id);
	String deleteWLProductByProdUserId(int userId, int prodId);

}

package com.ekart.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.config.ProductFeignClientWishList;
import com.ekart.entity.Kart;
import com.ekart.entity.WishList;
import com.ekart.repository.WishListRepository;

@Service
public class WishListServiceImpl implements WishListService{
	
	@Autowired
	WishListRepository wishListRepository;
	
	@Autowired
	ProductFeignClientWishList productFeignClientWishList;

	@Override
	public WishList addProductToWishList(int userId, int prodId) {
		// TODO Auto-generated method stub
		WishList wishList=productFeignClientWishList.getProductById(prodId);
		wishList.setUserId(userId);
		wishListRepository.save(wishList);
		return wishList;
	}

	@Override
	public List<WishList> getAllWishListProducts() {
		// TODO Auto-generated method stub
		return wishListRepository.findAll();
	}

	@Override
	public List<WishList> getWishListProductsByUserId(int userId) {
		// TODO Auto-generated method stub
		return wishListRepository.getWishListProductsByUserId(userId);
	}

	@Override
	public String deleteProductFromWishList(ObjectId id) {
		// TODO Auto-generated method stub
		Optional<WishList> prod=wishListRepository.findById(id);
		if(prod.isPresent())
		{
			wishListRepository.deleteById(id);
			return "Product deleted from wish list.";
		}
		return "Product not deleted from wish list.";
	}

	@Override
	public String deleteWLProductByProdUserId(int userId, int prodId) {
		// TODO Auto-generated method stub
		List<WishList> wls=wishListRepository.findAll();
		for(WishList obj : wls) {
			if(prodId == obj.getId() && userId == obj.getUserId())
			{
				wishListRepository.delete(obj);
			}
		}
		return "Deleted";
	}

	
}

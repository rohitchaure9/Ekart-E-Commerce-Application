package com.ekart.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ekart.entity.Kart;
import com.ekart.entity.WishList;

@FeignClient(name="productclientwishlist", url="http://localhost:8005/api/ekart/product")
public interface ProductFeignClientWishList {
	
	@GetMapping("/getAll")
	List<WishList> getAllProducts();
	
	@GetMapping("/get/{id}")
	WishList getProductById(@PathVariable int id);

}

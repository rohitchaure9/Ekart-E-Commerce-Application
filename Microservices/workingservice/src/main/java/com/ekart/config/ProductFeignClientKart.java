package com.ekart.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ekart.entity.Kart;

@FeignClient(name="productclientkart", url="http://localhost:8005/api/ekart/product")
public interface ProductFeignClientKart {
	@GetMapping("/getAll")
	List<Kart> getAllProducts();
	
	@GetMapping("/get/{id}")
	Kart getProductById(@PathVariable int id);
}

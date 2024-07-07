package com.ekart.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ekart.dto.Kart;

@FeignClient(name="kartFeignClient", url="http://localhost:8007/api/ekart/working")
public interface KartFeignClient {
	
	@GetMapping("/kart/user/{userId}")
	List<Kart> getKartProductsByUserId(@PathVariable int userId);
}

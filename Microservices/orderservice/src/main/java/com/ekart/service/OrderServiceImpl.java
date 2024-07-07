package com.ekart.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.config.KartFeignClient;
import com.ekart.dto.Kart;
import com.ekart.entity.Order;
import com.ekart.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	KartFeignClient kartFeignClient;
	
	@Autowired
	OrderRepository orderRepository;
	
	

	@Override
	public String cancelOrder(int userId, int prodId) {
		// TODO Auto-generated method stub
		List<Order> orders=orderRepository.getOrdersByUserId(userId);
		for(Order order: orders) {
			if(prodId==order.getId()) {
				orderRepository.delete(order);
			}
		}
		return "Order Deleted";
	}



	@Override
	public String placeOrder(int userId) {
		// TODO Auto-generated method stub
		List<Kart> karts= kartFeignClient.getKartProductsByUserId(userId); 
		for(Kart kart: karts) {
			
			Order order=new Order();
			
			order.setKartId(kart.getKartId());
			order.setUserId(kart.getUserId());
			order.setId(kart.getId());
			order.setName(kart.getName());
			order.setLink(kart.getLink());
			order.setCategory(kart.getCategory());
			order.setDescription(kart.getDescription());
			order.setPrice(kart.getPrice());
			order.setRating(kart.getRating());
			order.setQuantity(kart.getQuantity());
			order.setDateTime(LocalDateTime.now());
			order.setTotalPrice(kart.getTotalPrice());
			
			orderRepository.save(order);
			
		}
		return "Order Successful.";
	}



	@Override
	public List<Order> getAllOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		return orderRepository.getOrdersByUserId(userId);
	}
	
}

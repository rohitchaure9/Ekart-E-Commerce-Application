package com.ekart.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.config.ProductFeignClientKart;
import com.ekart.entity.Kart;
import com.ekart.repository.KartRepository;

@Service
public class KartServiceImpl implements KartService{
	
	@Autowired
	KartRepository kartRepository;
	
	@Autowired
	ProductFeignClientKart productFeignClientKart;

	@Override
	public Kart addProductToKart(int userId, int prodId) {
		// TODO Auto-generated method stub
		Kart kart= productFeignClientKart.getProductById(prodId);
		kart.setQuantity(1);
		kart.setUserId(userId);
		kart.setTotalPrice(kart.getPrice()*kart.getQuantity());
		kartRepository.save(kart);
		return kart;
	}

	@Override
	public List<Kart> getAllKartProducts() {
		// TODO Auto-generated method stub
		return kartRepository.findAll();
	}

	@Override
	public List<Kart> getKartProductsByUserId(int userId) {
		// TODO Auto-generated method stub
		return kartRepository.getKartProductsByUserId(userId);
	}

	@Override
	public String deleteProductFromKart(ObjectId id) {
		// TODO Auto-generated method stub
		Optional<Kart>emp = kartRepository.findById(id);
		if(emp.isPresent()){
			kartRepository.deleteById(id);
			return "User Deleted";
		}
		return "User not deleted.";
	}

	@Override
	public String deleteKartProductsByUserId(int userId) {
		// TODO Auto-generated method stub
		kartRepository.deleteKartProductsByUserId(userId);
		return "Deleted";
	}

	@Override
	public String deleteProductByProdUserId(int userId,int prodId) {
		// TODO Auto-generated method stub
		List<Kart> karts=kartRepository.findAll();
		for(Kart obj : karts) {
			if(prodId == obj.getId() && userId == obj.getUserId())
			{
				kartRepository.delete(obj);
			}
		}
		return "Deleted";
	}

	@Override
	public String incrementQuantity(int userId, int prodId) {
		// TODO Auto-generated method stub
		List<Kart> karts = kartRepository.findAll();
		for(Kart obj:karts) {
			if(prodId == obj.getId() && userId == obj.getUserId() ) {
				int x=obj.getQuantity();
				x=x+1;
				obj.setQuantity(x);
				obj.setTotalPrice(obj.getQuantity()*obj.getPrice());
				kartRepository.save(obj);
			}
		}
		return "Incremented";
	}

	@Override
	public String decrementQuantity(int userId, int prodId) {
		// TODO Auto-generated method stub
		List<Kart> karts = kartRepository.findAll();
		for(Kart obj:karts) {
			if(prodId == obj.getId() && userId == obj.getUserId() ) {
				int x=obj.getQuantity();
				if(x>1)
				{
					x=x-1;
					obj.setQuantity(x);
					obj.setTotalPrice(obj.getQuantity()*obj.getPrice());
					kartRepository.save(obj);
				}
				else {
					return "Cannot be incremented.";
				}
			}
		}
		return "Incremented";
	}
	
	

}

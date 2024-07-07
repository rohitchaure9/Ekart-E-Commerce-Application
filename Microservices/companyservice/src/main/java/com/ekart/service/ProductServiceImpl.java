package com.ekart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.entity.Product;
import com.ekart.exception.IdNotFoundException;
import com.ekart.exception.PriceIsNotValidException;
import com.ekart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products=productRepository.findAll();
		return products;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> pro = productRepository.findById(id);
		if(pro.isPresent())
		{
			return pro.get();
		}
		else {
			throw new IdNotFoundException("Product not found.");
		}
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		if(product.getPrice()<0)
		{
			throw new PriceIsNotValidException("Price cannot be negative.");
		}
		return productRepository.save(product);
	}

	@Override
	public Product updateProductById(int id, Product product) {
		// TODO Auto-generated method stub
		Optional<Product> pro=productRepository.findById(id);
		if(pro.isPresent())
		{
			return productRepository.save(product);
		}
		else
		{
			throw new IdNotFoundException("Product not found.");
		}
	}

	@Override
	public String deleteProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> pro=productRepository.findById(id);
		if(pro.isPresent())
		{
			productRepository.deleteById(id);
			return "Product Deleted Successfully!";
		}
		else
		{
			throw new IdNotFoundException("Product not found.");
		}
		
	}

	@Override
	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(category);
	}
	
	

}

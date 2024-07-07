package com.ekart.service;

import java.util.List;

import com.ekart.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(int id);
	Product addProduct(Product product);
	Product updateProductById(int id, Product product);
	String deleteProductById(int id);
	List<Product> findByCategory(String category);
}

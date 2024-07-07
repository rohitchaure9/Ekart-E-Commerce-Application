package com.ekart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.entity.Product;
import com.ekart.exception.IdNotFoundException;
import com.ekart.exception.PriceIsNotValidException;
import com.ekart.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/ekart/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product> (productService.addProduct(product),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<List<Product>> (productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<Product> getProductById(@PathVariable int id){
		return new ResponseEntity<Product> (productService.getProductById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	ResponseEntity<Product> updateProductById(@PathVariable int id, @RequestBody Product product){
		return new ResponseEntity<Product> (productService.updateProductById(id, product),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<String> deleteProductById(@PathVariable int id){
		return new ResponseEntity<String> (productService.deleteProductById(id),HttpStatus.OK); 
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<String> myIdException(IdNotFoundException exception){
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PriceIsNotValidException.class)
	ResponseEntity<String> myPriceException(PriceIsNotValidException exception){
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/category/{category}")
	ResponseEntity<List<Product>> getByCategory(@PathVariable String category){
		return new ResponseEntity<List<Product>> (productService.findByCategory(category),HttpStatus.OK);
	}
}

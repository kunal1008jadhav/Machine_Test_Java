package com.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Product;
import com.app.serviceI.ProductServiceI;

@RestController
@RequestMapping("/api")
public class ProductContoller {
	
	@Autowired 
	ProductServiceI productServiceI;
	

	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product){
		Product addProduct = productServiceI.addProduct(product);
		return addProduct;
	}
	
	@GetMapping("/products/{productId}")
	public Optional<Product> getSingleProductById(@PathVariable("productId") Integer id){
		Optional<Product> singleProductById = productServiceI.getSingleProductById(id);
		return singleProductById;
	}
	
	@PutMapping("/products/{productId}")
	public Optional<Product> updateProductById(@PathVariable("productId") Integer id, @RequestBody Product product){
		Optional<Product> singleProductById = productServiceI.getSingleProductById(id);
		if(singleProductById.isPresent())
			productServiceI.addProduct(product);
		return singleProductById;
	}
	
	@DeleteMapping("/products/{productId}")
	public void deleteProductById(@PathVariable("productId") Integer id) {
		productServiceI.deleteProductById(id);
	}
	@GetMapping("/products")
	public Page<Product> getAllProductById(
			
			@RequestParam(value="page",defaultValue="0",required=false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="5",required=false) Integer pageSize
			) {
		Page<Product> productByPaging = productServiceI.getProductByPaging(pageNumber, pageSize);
		return productByPaging;
	}
	

}

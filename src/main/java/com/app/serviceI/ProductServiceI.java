package com.app.serviceI;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.app.models.Product;

public interface ProductServiceI {

	List<Product> getAllProduct();

	Product addProduct(Product product);

	Optional<Product> getSingleProductById(Integer id);

	void deleteProductById(Integer id);
	
	Page<Product> getProductByPaging(Integer pageNumber, Integer pageSize);

}

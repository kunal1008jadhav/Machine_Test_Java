package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.models.Product;
import com.app.repositories.ProductRepository;
import com.app.serviceI.ProductServiceI;
@Service
public class ProductServiceImpl implements ProductServiceI{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProduct() {
		List<Product> findAll = productRepository.findAll();
		return findAll;
	}
	@Override
	public Page<Product> getProductByPaging(Integer pageNumber, Integer pageSize ){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		Page<Product> allpages = productRepository.findAll(page);
		return allpages;
	}
	@Override
	public Product addProduct(Product product) {
		Product save = productRepository.save(product);
		return save;
	}

	@Override
	public Optional<Product> getSingleProductById(Integer id) {
		Optional<Product> findById = productRepository.findById(id);
		return findById;
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}

}

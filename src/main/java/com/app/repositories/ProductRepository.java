package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	

}

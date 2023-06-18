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

import com.app.models.Category;
import com.app.serviceI.CategoryServiceI;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryServiceI categoryServiceI;

	//1.GET all the categories
	@GetMapping("/categories")
	public Page<Category> getAllCategoryWithPagination(
			@RequestParam(value  = "page", defaultValue="0",required= false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue="2", required= false)Integer pageSize
			) {
		Page<Category> findAllWithPagination = categoryServiceI.categoryFindAllWithPagination(pageNumber, pageSize);
		return findAllWithPagination;
	}

	//2.POST - create a new category
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category)
	{
		Category addCategory = categoryServiceI.addCategory(category);
		return addCategory;
	}
	
	//3.GET category by Id
	@GetMapping("/categories/{categoryId}")
	public Optional<Category> getSingleCategoryById(@PathVariable("categoryId") Integer id) {
		Optional<Category> singleCategory = categoryServiceI.getSingleCategory(id);
		return singleCategory;
	}
	
	//4.PUT - update category by id
	@PutMapping("/categories/{categoryId}")
	public Optional<Category> editCategoryById(@PathVariable("categoryId") Integer id, @RequestBody Category category){
		Optional<Category> singleCategory = categoryServiceI.getSingleCategory(id);
		if(singleCategory.isPresent())
			categoryServiceI.addCategory(category);
		return singleCategory;
	}
	
	//5.DELETE - Delete category by id
	@DeleteMapping("/categories/{categoryId}")
	public void deleteCategoryById(@PathVariable("categoryId") Integer id) {
		categoryServiceI.deleteCategoryById(id);
		
	}
	
	
	
	
}

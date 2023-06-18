package com.app.serviceI;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.app.models.Category;

public interface CategoryServiceI {

	List<Category> allCategory();

	Category addCategory(Category category);

	Optional<Category> getSingleCategory(Integer id);

	void deleteCategoryById(Integer id);
	
	Page<Category> categoryFindAllWithPagination(Integer pageNumber, Integer pageSize);
	
	

}

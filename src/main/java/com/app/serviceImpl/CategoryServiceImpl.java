package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.models.Category;
import com.app.repositories.CategoryRepository;
import com.app.serviceI.CategoryServiceI;


@Service
public class CategoryServiceImpl implements CategoryServiceI{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> allCategory() {
		List<Category> allCategory = categoryRepository.findAll();
		return allCategory;	
	}
	@Override
	public Category addCategory(Category category) {
		Category save = categoryRepository.save(category);
		return save;
	}
	@Override
	public Optional<Category> getSingleCategory(Integer id) {
		Optional<Category> findById = categoryRepository.findById(id);
		return findById;
		
	}
	@Override
	public void deleteCategoryById(Integer id) {
		categoryRepository.deleteById(id);
		
	}
	
	public Page<Category> categoryFindAllWithPagination(Integer pageNumber, Integer pageSize) {
		Pageable categoryPages = PageRequest.of(pageNumber, pageSize);
		Page<Category> findAll = categoryRepository.findAll(categoryPages);
		return findAll;
	}

}

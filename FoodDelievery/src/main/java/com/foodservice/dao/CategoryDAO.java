package com.foodservice.dao;

import java.util.List;

import com.foodservice.entity.Category;

public interface CategoryDAO 
{
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public List<Category> retrieveCategories();
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryId);

}

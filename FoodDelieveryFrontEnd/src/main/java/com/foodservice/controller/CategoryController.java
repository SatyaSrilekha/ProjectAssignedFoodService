package com.foodservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodservice.dao.CategoryDAO;
import com.foodservice.entity.Category;

@Controller
public class CategoryController 
{
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/category")
	public String showCategoryPage(Model m)
	{	
		List<Category> categoryList=categoryDAO.retrieveCategories();
		m.addAttribute("categoryList", categoryList);
		return "Category";
	}
	
	@RequestMapping(value="/insertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String categoryName,
			@RequestParam("description")String description,Model m)
	{
		Category category=new Category();
		category.setCategoryId(categoryId);
		category.setCategoryName(categoryName);
		category.setDescription(description);
		
		categoryDAO.addCategory(category);
		
		List<Category> categoryList=categoryDAO.retrieveCategories();
		m.addAttribute("categoryList", categoryList);
		return "Category";		
	}
	
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(category);
		
		List<Category> categoryList=categoryDAO.retrieveCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}

	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		m.addAttribute("category", category);
		return "UpdateCategory";
	}

	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String categoryName,
			@RequestParam("description")String description,Model m)
	{		
		Category category=categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setDescription(description);
		
		categoryDAO.updateCategory(category);
		
		List<Category> categoryList=categoryDAO.retrieveCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}

	@RequestMapping(value="/categoryDisplay",method=RequestMethod.GET)
	public String categoryDisplay(Model m)
	{
		List<Category> categoryList=categoryDAO.retrieveCategories();
		m.addAttribute("categoryList", categoryList);
		return "CategoryDisplay";
	}
	
	

}

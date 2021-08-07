package com.foodservice.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodservice.dao.CategoryDAO;
import com.foodservice.entity.Category;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.foodservice");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}	
	@Test
	public void addCategoryTest() 
	{
		Category category=new Category();
		category.setCategoryId(1007);
		category.setCategoryName("Sandwitches");
		category.setDescription("Crunchy crispy sandwitches");		
		assertTrue("Problem occured while adding",categoryDAO.addCategory(category));		
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest() 
	{
		Category category=categoryDAO.getCategory(1004);
		assertTrue("Problem occured while deleting",categoryDAO.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void retrieveCategoriesTest()
	{
		List<Category> categoryList=categoryDAO.retrieveCategories();
		assertTrue("Problem occured in retrieving",categoryList.size()>=1);
		
		for(Category category:categoryList)
		{
			System.out.println("Category Id:"+category.getCategoryId());
			System.out.println("Category Name:"+category.getCategoryName());
			System.out.println("Category Description:"+category.getDescription());
			
		}
	}

}

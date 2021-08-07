package com.foodservice.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodservice.dao.ItemDAO;

import com.foodservice.entity.Item;


public class ItemDAOTest {

	static ItemDAO itemDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.foodservice");
		context.refresh();
		itemDAO=(ItemDAO)context.getBean("itemDAO");
	}
	
	@Ignore
	@Test
	public void addItemTest() 
	{
		Item item=new Item();
		item.setItemId("I202");
		item.setItemName("VanilaCake");
		item.setCategoryId(1002);
		item.setSupplierId("SP1002");
		item.setStock("Available");
		assertTrue("Problem occured while adding",itemDAO.addItem(item));		
	}
	
	
	@Ignore
	@Test
	public void deleteItemTest() 
	{
		Item item=itemDAO.getItem("I1002");
		assertTrue("Problem occured while deleting",itemDAO.deleteItem(item));
	}
	
	@Ignore
	@Test
	public void retrieveCategoriesTest()
	{
		List<Item> itemList=itemDAO.retrieveItems();
		assertTrue("Problem occured in retrieving",itemList.size()>=1);
		
		for(Item item:itemList)
		{
			System.out.println("Item Id:"+item.getItemId());
			System.out.println("Item Name:"+item.getItemName());
			System.out.println("Category Id:"+item.getCategoryId());
			System.out.println("Supplier Id:"+item.getSupplierId());
			System.out.println("Stock:"+item.getStock());
			
		}
	}
	
	@Test
	public void updateItemTest()
	{
		Item item=new Item();
		item.setItemId("I202");
		item.setItemName("VanilaCake");
		item.setCategoryId(1002);
		item.setSupplierId("SP1002");		
		item.setStock("unavailable");
		assertTrue("Problem occured while updating",itemDAO.updateItem(item));
	}

}

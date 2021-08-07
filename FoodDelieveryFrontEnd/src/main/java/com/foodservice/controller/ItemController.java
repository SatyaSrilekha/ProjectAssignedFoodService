package com.foodservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodservice.dao.ItemDAO;

import com.foodservice.entity.Item;

@Controller
public class ItemController 
{
	
	@Autowired
	ItemDAO itemDAO;
	
	@RequestMapping("/item")
	public String showItemPage(Model m)
	{	
		List<Item> itemList=itemDAO.retrieveItems();
		m.addAttribute("itemList", itemList);
		return "Item";
	}
	
	@RequestMapping(value="/insertItem",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("itemId")String itemId,@RequestParam("itemName")String itemName,
			@RequestParam("categoryId")int categoryId,	@RequestParam("supplierId")String supplierId,		
			@RequestParam("stock")String stock,Model m)
	{
		Item item=new Item();
		item.setItemId(itemId);
		item.setItemName(itemName);
		item.setCategoryId(categoryId);
		item.setSupplierId(supplierId);
		item.setStock(stock);
		
		itemDAO.addItem(item);
		
		List<Item> itemList=itemDAO.retrieveItems();
		m.addAttribute("itemList", itemList);
		return "Item";		
	}
	
	@RequestMapping("/deleteItem/{itemId}")
	public String deleteItem(@PathVariable("itemId")String itemId,Model m)
	{
		Item item=itemDAO.getItem(itemId);
		itemDAO.deleteItem(item);
		
		List<Item> itemList=itemDAO.retrieveItems();
		m.addAttribute("itemList", itemList);
		
		return "Item";
	}

	@RequestMapping("/editItem/{itemId}")
	public String editItem(@PathVariable("itemId")String itemId,Model m)
	{
		Item item=itemDAO.getItem("itemId");
		m.addAttribute("item", item);
		return "UpdateItem";
	}

	@RequestMapping(value="/updateItem",method=RequestMethod.POST)
	public String updateItem(@RequestParam("itemId")String itemId,@RequestParam("itemName")String itemName,
			@RequestParam("categoryId")int categoryId,	@RequestParam("supplierId")String supplierId,		
			@RequestParam("stock")String stock,Model m)
	{		
		Item item=new Item();
		item.setItemId(itemId);
		item.setItemName(itemName);
		item.setCategoryId(categoryId);
		item.setSupplierId(supplierId);
		item.setStock(stock);
		
		itemDAO.updateItem(item);
		
		List<Item> itemList=itemDAO.retrieveItems();
		m.addAttribute("itemList", itemList);
		return "Item";		

	}
	
	@RequestMapping(value="/itemsDisplay",method=RequestMethod.GET)
	public String showItemDisplayPage(Model m)
	{
		List<Item> itemList=itemDAO.retrieveItems();
		m.addAttribute("itemList", itemList);
		return "ItemsDisplay";
	}

}

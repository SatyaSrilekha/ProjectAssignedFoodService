package com.foodservice.dao;

import java.util.List;

import com.foodservice.entity.Item;

public interface ItemDAO 
{
	public boolean addItem(Item item);
	public boolean deleteItem(Item item);
	public List<Item> retrieveItems();
	public boolean updateItem(Item item);
	public Item getItem(String itemId);


}

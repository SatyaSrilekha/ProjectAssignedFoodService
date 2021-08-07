package com.foodservice.dao;

import java.util.List;

import com.foodservice.entity.Orders;

public interface OrderDAO 
{
	public boolean addOrder(Orders order);
	public boolean deleteOrder(Orders order);
	public List<Orders> retrieveOrders();
	public boolean updateOrder(Orders order);
	public Orders getOrder(String orderId);

}

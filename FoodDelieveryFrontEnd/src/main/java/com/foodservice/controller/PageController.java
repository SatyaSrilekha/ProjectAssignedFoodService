package com.foodservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodservice.dao.OrderDAO;
import com.foodservice.entity.Category;
import com.foodservice.entity.Item;
import com.foodservice.entity.Orders;

/*@Controller
public class PageController 
{
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping("/order")
	public String showOrderPage(Model m)
	{	
		List<Orders> orderList=orderDAO.retrieveOrders();
		m.addAttribute("orderList", orderList);
		return "OrderForm";
	}
	
	@RequestMapping(value="/insertOrder",method=RequestMethod.POST)
	public String insertOrder(@RequestParam("orderId")String orderId,@RequestParam("itemName")String itemName,
								@RequestParam("orderDate")String orderDate,@RequestParam("amount")String amount,
								@RequestParam("mobileNumber")String mobileNumber,Model m)
	{	
		Orders orders=new Orders();
		orders.setOrderId(orderId);
		orders.setItemName(itemName);
		orders.setOrderDate(orderDate);
		orders.setAmount(amount);
		orders.setMobileNumber(mobileNumber);
		
		orderDAO.addOrder(orders);
		
		List<Orders> orderList=orderDAO.retrieveOrders();
		m.addAttribute("orderList", orderList);
		return "OrderForm";		
	}
}*/
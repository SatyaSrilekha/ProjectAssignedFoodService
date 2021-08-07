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

@Controller
public class OrderController 
{
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping("/order")
	public String showOrderPage(Model m)
	{	
		List<Orders> orderList=orderDAO.retrieveOrders();
		m.addAttribute("orderList", orderList);
		return "Order";
	}
	
	@RequestMapping(value="/insertOrder",method= {RequestMethod.POST,RequestMethod.GET})
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
		return "Order";		
	}
	
	@RequestMapping("/deleteOrder/{orderId}")
	public String deleteOrder(@PathVariable("orderId")String orderId,Model m)
	{
		Orders order=orderDAO.getOrder(orderId);
		orderDAO.deleteOrder(order);
		
		List<Orders> orderList=orderDAO.retrieveOrders();
		m.addAttribute("orderList", orderList);
		
		return "Order";
	}
	
	@RequestMapping("/editOrder/{orderId}")
	public String editOrder(@PathVariable("orderId")String orderId,Model m)
	{
		Orders order=orderDAO.getOrder("orderId");
		m.addAttribute("order", order);
		return "UpdateOrder";
	}

	@RequestMapping(value="/updateOrder",method=RequestMethod.POST)
	public String updateOrder(@RequestParam("orderId")String orderId,@RequestParam("itemName")String itemName,
			@RequestParam("orderDate")String orderDate,@RequestParam("amount")String amount,
			@RequestParam("mobileNumber")String mobileNumber,Model m)
	{		
		Orders order=new Orders();
		order.setOrderId(orderId);
		order.setItemName(itemName);
		order.setOrderDate(orderDate);
		order.setAmount(amount);
		order.setMobileNumber(mobileNumber);
				
		orderDAO.updateOrder(order);
		
		List<Orders> orderList=orderDAO.retrieveOrders();
		m.addAttribute("orderList", orderList);
		return "Order";		

	}
	/*@RequestMapping("/addOrder")
	public String addOrder(@PathVariable("orderId")String orderId,@RequestParam("itemName")String itemName,
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
		
		return "Order";
	}*/
	
}

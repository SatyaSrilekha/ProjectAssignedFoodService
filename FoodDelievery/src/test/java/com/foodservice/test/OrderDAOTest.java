package com.foodservice.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodservice.dao.OrderDAO;
import com.foodservice.entity.Orders;

public class OrderDAOTest 
{
	static OrderDAO orderDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.foodservice");
		context.refresh();
		orderDAO=(OrderDAO)context.getBean("orderDAO");
	}
	
	@Ignore
	@Test
	public void addOrderTest() 
	{
		Orders order=new Orders();
		order.setOrderId("OR106");
		order.setItemName("HoneyCake");
		order.setOrderDate("29/07/2021");
		order.setAmount("20/-");
		order.setMobileNumber("9876543665");
		assertTrue("Problem occured while adding",orderDAO.addOrder(order));		
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest() 
	{
		Orders order=orderDAO.getOrder("OR102");
		assertTrue("Problem occured while deleting",orderDAO.deleteOrder(order));
	}
	
	
	@Test
	public void retrieveOrdersTest()
	{
		List<Orders> orderList=orderDAO.retrieveOrders();
		assertTrue("Problem occured in retrieving",orderList.size()>=1);
		
		for(Orders order:orderList)
		{
			System.out.println("Order Id:"+order.getOrderId());
			System.out.println("First Name:"+order.getItemName());
			System.out.println("Order Date:"+order.getOrderDate());
			System.out.println("Amount:"+order.getAmount());
			System.out.println("Mobile number:"+order.getMobileNumber());
			
		}
	}

}



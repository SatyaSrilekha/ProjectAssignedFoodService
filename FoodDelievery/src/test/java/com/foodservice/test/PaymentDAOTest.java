package com.foodservice.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodservice.dao.PaymentDAO;

import com.foodservice.entity.Payments;

public class PaymentDAOTest {

	static PaymentDAO paymentDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.foodservice");
		context.refresh();
		paymentDAO=(PaymentDAO)context.getBean("paymentDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest() 
	{
		Payments payment=new Payments();
		payment.setPaymentId("Pid1002");
		payment.setOrderId("OR103");
		payment.setModeOfTrans("cash");
		payment.setMobileNumber("9988776655");
		payment.setTotal(600);
		assertTrue("Problem occured while adding",paymentDAO.addPayment(payment));		
	}
	
	@Ignore
	@Test
	public void deletePaymentTest() 
	{
		Payments payment=paymentDAO.getPayment("Pid1001");
		assertTrue("Problem occured while deleting",paymentDAO.deletePayment(payment));
	}
	
	@Ignore
	@Test
	public void retrievePaymentsTest()
	{
		List<Payments> paymentList=paymentDAO.retrievePayments();
		assertTrue("Problem occured in retrieving",paymentList.size()>=1);
		
		for(Payments payment:paymentList)
		{
			System.out.println("Payment Id:"+payment.getPaymentId());
			System.out.println("Order Id:"+payment.getOrderId());
			System.out.println("Mode of transaction:"+payment.getModeOfTrans());
			System.out.println("Mobile number:"+payment.getMobileNumber());
			System.out.println("Total:"+payment.getTotal());
			
		}
	}



}

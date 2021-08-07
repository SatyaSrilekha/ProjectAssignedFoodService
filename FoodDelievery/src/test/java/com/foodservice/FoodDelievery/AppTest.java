package com.foodservice.FoodDelievery;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest 
{
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.foodservice");
		context.refresh();
	}
	
	@Test
	public void doTest()
	{
		System.out.println("Yes");
	}
}
package com.foodservice.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodservice.dao.UserDetailDAO;
import com.foodservice.entity.UserDetail;

public class UserDetailDAOTest {

	static UserDetailDAO userDetailDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.foodservice");
		context.refresh();
		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	}
	@Ignore
	@Test
	public void addUserDetailDAOTest() 
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setUserName("Kajal");
		userDetail.setPassword("kaju$12");
		userDetail.setEnabled(true);
		userDetail.setRole("ROLE_USER");
		userDetail.setEmailId("kaju22@gmail.com");
		userDetail.setMobileNumber("8765434562");
		userDetail.setAddress("Chennai");
		assertTrue("Problem occured while adding",userDetailDAO.registerUser(userDetail));		
	}
	
	@Test
	public void registerUserTest()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setUserName("Siri");
		userDetail.setPassword("sri");
		userDetail.setEnabled(true);
		userDetail.setRole("ROLE_USER");
		userDetail.setEmailId("siri22@gmail.com");
		userDetail.setMobileNumber("8765434562");
		userDetail.setAddress("Chennai");
		assertTrue("Problem occured while adding",userDetailDAO.registerUser(userDetail));		
	}

}

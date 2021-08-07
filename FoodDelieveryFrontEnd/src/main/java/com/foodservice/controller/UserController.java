package com.foodservice.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodservice.dao.UserDetailDAO;
import com.foodservice.entity.UserDetail;


@Controller
public class UserController {
	
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@RequestMapping(value="/login_success",method=RequestMethod.POST)
    public String successfullLogin(HttpSession session)
    {
		String page="";
		
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String userName=authentication.getName();
		session.setAttribute("userName", userName);
		
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role",role.getAuthority());
			if(role.getAuthority().equals("ROLE_ADMIN"))
				page="AdminHome";
			else
				page="UserHome";
		}
		
		  
		return page;
    }
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
    public String showLoginPage()
    {
		System.out.println("opening login page");
    return"Login";
    }
	
	@RequestMapping("/register")
    public String showRegisterPage()
    {
    return"Register";
    }
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String registerUser(@RequestParam("userName")String userName,@RequestParam("password")String password,
								@RequestParam("emailId")String emailId,@RequestParam("mobileNumber")String mobileNumber,
								@RequestParam("address")String address)
	{
		
		
		System.out.println("UserName:"+userName);
		System.out.println("Password:"+password);
		System.out.println("EmailId:"+emailId);
		System.out.println("MobileNumber:"+mobileNumber);
		System.out.println("Address:"+address);
		
		org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder=new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
		String password1=encoder.encode(password);
		
		UserDetail userdetail=new UserDetail();
		userdetail.setUserName(userName);
		userdetail.setPassword(password1);
		userdetail.setEnabled(true);
		userdetail.setRole("ROLE_USER");
		userdetail.setEmailId(emailId);
		userdetail.setMobileNumber(mobileNumber);
		userdetail.setAddress(address);		
		 userDetailDAO.registerUser(userdetail);
		
		return "ConfirmRegister";
	}
}

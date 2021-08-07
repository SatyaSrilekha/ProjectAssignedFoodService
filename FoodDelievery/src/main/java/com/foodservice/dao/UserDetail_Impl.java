package com.foodservice.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodservice.entity.UserDetail;

@Repository("userDetailDAO")
@Transactional
public class UserDetail_Impl implements UserDetailDAO  
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserDetail userDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(userDetail);
			System.out.println("data working!!!");
			return true;
		}
		catch(Exception e)
		{
	    System.out.println("Exception"+e);		
		return false;
		}
	}

	@Override
	public UserDetail getUser(String userName) {
		
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class,userName);
		session.close();
		return userDetail;
	}

	@Override
	public boolean updateUser(UserDetail userDetail) {
		try
		{
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
	    System.out.println("Exception"+e);		
		return false;
		}
	}

}

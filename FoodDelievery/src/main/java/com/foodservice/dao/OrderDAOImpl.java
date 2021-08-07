package com.foodservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodservice.entity.Category;
import com.foodservice.entity.Orders;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addOrder(Orders order) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(order);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public boolean deleteOrder(Orders order) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(order);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}	
	}

	@Override
	public List<Orders> retrieveOrders() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Orders");
		List<Orders> orderList=query.list();
		session.close();
		return orderList;
	}

	@Override
	public boolean updateOrder(Orders order) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(order);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public Orders getOrder(String orderId) 
	{
		Session session=sessionFactory.openSession();
		Orders order=session.get(Orders.class,orderId);
		session.close();
		return order;

	}

}

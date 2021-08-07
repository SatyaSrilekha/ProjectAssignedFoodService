package com.foodservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.foodservice.entity.Item;

@Repository("itemDAO")
@Transactional
public class ItemDAOImpl implements ItemDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addItem(Item item) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(item);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public boolean deleteItem(Item item) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(item);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public List<Item> retrieveItems() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Item");
		List<Item> itemList=query.list();
		session.close();
		return itemList;
	}

	@Override
	public boolean updateItem(Item item) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(item);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public Item getItem(String itemId) {
		Session session=sessionFactory.openSession();
		Item item=session.get(Item.class,itemId);
		session.close();
		return item;
	}

}

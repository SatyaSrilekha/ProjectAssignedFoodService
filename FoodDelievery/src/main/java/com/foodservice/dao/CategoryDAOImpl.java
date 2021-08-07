package com.foodservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.foodservice.entity.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}		
	}

	@Override
	public boolean deleteCategory(Category category) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}		
	}

	@Override
	public List<Category> retrieveCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> categoryList=query.list();
		session.close();
		return categoryList;
	}

	@Override
	public boolean updateCategory(Category category) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=session.get(Category.class,categoryId);
		session.close();
		return category;
	}
	
}

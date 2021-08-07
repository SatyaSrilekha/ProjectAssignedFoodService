package com.foodservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.foodservice.entity.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
		
	}

	@Override
	public List<Supplier> retrieveSupplier() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> supplierList=query.list();
		session.close();
		return supplierList;
	}

	@Override
	public boolean updateSupplier(Supplier supplier) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(supplier);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}	
	}


	@Override
	public Supplier getSupplier(String supplierId) {
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

}

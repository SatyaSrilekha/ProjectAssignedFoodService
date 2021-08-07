package com.foodservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.foodservice.entity.Category;
import com.foodservice.entity.Payments;

@Repository("paymentDAO")
@Transactional
public class PaymentDAOImpl implements PaymentDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addPayment(Payments payment) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(payment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public boolean deletePayment(Payments payment) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(payment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public List<Payments> retrievePayments() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Payments");
		List<Payments> paymentList=query.list();
		session.close();
		return paymentList;
	}

	@Override
	public boolean updatePayment(Payments payment) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(payment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception:" +e);
			return false;
		}
	}

	@Override
	public Payments getPayment(String paymentId) 
	{
		Session session=sessionFactory.openSession();
		Payments payment=session.get(Payments.class,paymentId);
		session.close();
		return payment;			
	}

}

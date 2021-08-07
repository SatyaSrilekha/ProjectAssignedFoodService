package com.foodservice.dao;

import java.util.List;

import com.foodservice.entity.Payments;

public interface PaymentDAO 
{
	public boolean addPayment(Payments payment);
	public boolean deletePayment(Payments payment);
	public List<Payments> retrievePayments();
	public boolean updatePayment(Payments payment);
	public Payments getPayment(String paymentId);
}

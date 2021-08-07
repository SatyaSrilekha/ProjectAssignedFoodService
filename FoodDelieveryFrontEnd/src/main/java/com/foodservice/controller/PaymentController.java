package com.foodservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodservice.dao.PaymentDAO;
import com.foodservice.entity.Category;
import com.foodservice.entity.Payments;

@Controller
public class PaymentController 
{
	
	@Autowired
	PaymentDAO paymentDAO;
	
	@RequestMapping("/payment")
	public String showPaymentPage(Model m)
	{	
		List<Payments> paymentList=paymentDAO.retrievePayments();
		m.addAttribute("paymentList", paymentList);
		return "Payment";
	}
	
	@RequestMapping(value="/insertPayment",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("paymentId")String paymentId,@RequestParam("orderId")String orderId,
			@RequestParam("ModeOfTrans")String ModeOfTrans,
			@RequestParam("mobileNumber")String mobileNumber,@RequestParam("total")int total,Model m)
	{
		Payments payment=new Payments();
		payment.setPaymentId(paymentId);
		payment.setOrderId(orderId);
		payment.setModeOfTrans(ModeOfTrans);
		payment.setMobileNumber(mobileNumber);
		payment.setTotal(total);
		
		paymentDAO.addPayment(payment);
		
		List<Payments> paymentList=paymentDAO.retrievePayments();
		m.addAttribute("paymentList", paymentList);
		return "Payment";		
	}
	
	@RequestMapping("/deletePayment/{paymentId}")
	public String deletePayment(@PathVariable("paymentId")String paymentId,Model m)
	{
		Payments payment=paymentDAO.getPayment(paymentId);
		paymentDAO.deletePayment(payment);
		
		List<Payments> paymentList=paymentDAO.retrievePayments();
		m.addAttribute("paymentList", paymentList);
		return "Payment";
	}
	
	@RequestMapping("/editPayment/{paymentId}")
	public String editPayment(@PathVariable("paymentId")String paymentId,Model m)
	{
		Payments payment=paymentDAO.getPayment(paymentId);
		m.addAttribute("payment", payment);
		return "UpdatePayment";
	}

	@RequestMapping(value="/updatePayment",method=RequestMethod.POST)
	public String updatePayment(@RequestParam("paymentId")String paymentId,@RequestParam("orderId")String orderId,
			@RequestParam("ModeOfTrans")String ModeOfTrans,
			@RequestParam("mobileNumber")String mobileNumber,@RequestParam("total")int total,Model m)
	{		
		Payments payment=paymentDAO.getPayment(paymentId);
		payment.setPaymentId(paymentId);
		payment.setOrderId(orderId);
		payment.setModeOfTrans(ModeOfTrans);
		payment.setMobileNumber(mobileNumber);
		payment.setTotal(total);
		
		paymentDAO.updatePayment(payment);
		
		List<Payments> paymentList=paymentDAO.retrievePayments();
		m.addAttribute("paymentList", paymentList);
		
		return "Payment";
	}

}
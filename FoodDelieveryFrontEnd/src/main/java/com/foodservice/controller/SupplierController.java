package com.foodservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodservice.dao.SupplierDAO;
import com.foodservice.entity.Supplier;

@Controller
public class SupplierController 
{
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/supplier")
	public String showSupplierPage(Model m)
	{	
		List<Supplier> supplierList=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList", supplierList);
		return "Supplier";
	}
	
	@RequestMapping(value="/insertSupplier",method=RequestMethod.POST)
	public String insertSupplier(@RequestParam("supplierId")String supplierId,@RequestParam("supplierName")String supplierName,
			@RequestParam("supplierDesc")String supplierDesc,Model m)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> supplierList=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList", supplierList);
		return "Supplier";		
	}
	
	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")String supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> supplierList=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList", supplierList);
		return "Supplier";
	}

	@RequestMapping("/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")String supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		m.addAttribute("supplier",supplier);
		return "UpdateSupplier";
	}

	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("supplierId")String supplierId,@RequestParam("supplierName")String supplierName,
			@RequestParam("supplierDesc")String supplierDesc,Model m)
	{		
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplier.setSupplierId(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> supplierList=supplierDAO.retrieveSupplier();
		m.addAttribute("supplierList", supplierList);
		
		return "Supplier";
	}	

}

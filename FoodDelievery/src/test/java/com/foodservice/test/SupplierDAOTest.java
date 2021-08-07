package com.foodservice.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodservice.dao.SupplierDAO;
import com.foodservice.entity.Category;
import com.foodservice.entity.Supplier;


public class SupplierDAOTest 
{
	static SupplierDAO supplierDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.foodservice");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Ignore
	@Test
	public void addSupplierTest() 
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId("SP1005");
		supplier.setSupplierName("SnowManchuria");
		supplier.setSupplierDesc("Provides munching manchuria");		
		assertTrue("Problem occured while adding",supplierDAO.addSupplier(supplier));		
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier("SP1002");
		assertTrue("Problem occured while deleting",supplierDAO.deleteSupplier(supplier));

	}	
	
	@Test
	public void retrieveCategoriesTest()
	{
		List<Supplier> supplierList=supplierDAO.retrieveSupplier();
		assertTrue("Problem occured in retrieving",supplierList.size()>=1);
		
		for(Supplier supplier:supplierList)
		{
			System.out.println("Supplier Id:"+supplier.getSupplierId());
			System.out.println("Supplier Name:"+supplier.getSupplierName());
			System.out.println("Supplier Description:"+supplier.getSupplierDesc());
			
		}
	}
	

}

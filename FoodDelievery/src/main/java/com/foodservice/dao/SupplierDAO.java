package com.foodservice.dao;

import java.util.List;

import com.foodservice.entity.Supplier;

public interface SupplierDAO 
	{
		public boolean addSupplier(Supplier supplier);
		public boolean deleteSupplier(Supplier supplier);
		public List<Supplier> retrieveSupplier();
		public boolean updateSupplier(Supplier supplier);
		public Supplier getSupplier(String string);

	}




package com.shop.dao;

import java.util.List;

import com.shop.model.Supplier;

public interface SupplierDao {

	boolean addSupplier(Supplier supplier);
	Supplier get(String id);
	List<Supplier> supplierList();
	
}

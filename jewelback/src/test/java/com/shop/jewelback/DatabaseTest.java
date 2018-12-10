package com.shop.jewelback;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.dao.SupplierDao;
import com.shop.model.Supplier;


public class DatabaseTest {

	static Supplier supplier;
	static SupplierDao supplierdao;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();	
		supplierdao = (SupplierDao) context.getBean("supplierdao");
	}
	
	@Test
	public void addSupplierTest() {
		// add
		supplier = new Supplier();
		supplier.setSupplierId("1");
		supplier.setSupplierName("priya");
		assertEquals("Added", true, supplierdao.addSupplier(supplier));
		
	}
	
}

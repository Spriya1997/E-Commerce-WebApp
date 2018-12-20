package com.shop.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.SupplierDao;
import com.shop.model.Supplier;

@Repository("supplierdao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addSupplier(Supplier supplier) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Supplier> supplierList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> list=session.createQuery("from SupplierTable").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	@Override
	public Supplier get(String id) {			
		return sessionFactory.getCurrentSession().get(Supplier.class, id);
	}

}

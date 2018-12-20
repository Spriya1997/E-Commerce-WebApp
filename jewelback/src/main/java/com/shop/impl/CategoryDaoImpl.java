package com.shop.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.CategoryDao;
import com.shop.model.Category;

@Repository("categorydao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public boolean addCategory(Category category) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(category);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		
				
		@Override
		public Category get(String id) {			
			return sessionFactory.getCurrentSession().get(Category.class, id);
		}


		@Override
		@SuppressWarnings("unchecked")
		public List<Category> categoryList() {
			Session session = sessionFactory.openSession();
			session.beginTransaction();		
			List<Category> list=session.createQuery("from CategoryTable").list();
			session.getTransaction().commit();
			session.close();
			return list;
		}


	}




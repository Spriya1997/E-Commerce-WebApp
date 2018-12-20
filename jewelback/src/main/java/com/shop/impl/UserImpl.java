package com.shop.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.UserDao;
import com.shop.model.User;

@Repository("userdao")
@Transactional
public class UserImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> userList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<User> list=session.createQuery("from usertable").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public User get(String userEmail) {
		//return sessionFactory.getCurrentSession().get(User.class, userEmail);
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		User user=(User) session.createQuery("FROM UserTable WHERE email = :email").setParameter("email", userEmail).getSingleResult();
	//	User user=session.get(User.class, email);
		session.getTransaction().commit();
		return user;
	}

}
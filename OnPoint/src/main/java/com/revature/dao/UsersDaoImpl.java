package com.revature.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Users;

@Transactional
@Component(value="usersDao")
@Scope(value="prototype")
public class UsersDaoImpl implements UsersDao{

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public Users namedQueryGetUserByUsername(String username) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.getNamedQuery("namedQueryGetUserByUsername");
		q.setString("username", username);
		List<Users> ul = q.list();
		Iterator<Users> it = ul.iterator();
		Users u = it.next();
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return u;
	}
	
	@Override
	public List<Users> getAllUsers() {
		Session s = sessionFactory.getCurrentSession();
		List<Users> Users = s.createQuery("from Op_users").list();
		if(s.isOpen()) {
			s.close();
		}
		return Users;
	}

	@Override
	public int addUser(Users u) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(u);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return result;
	}

	@Override
	public void updateUser(Users u) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(u);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		
	}

	@Override
	public void deleteUser(Users u) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(u);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
	}

}

package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Event;

@Transactional
@Component(value="eventsDao")
@Scope(value="prototype")
public class EventsDaoImpl implements EventsDao {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Event> namedQueryGetEventsByUserId(int id){
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.getNamedQuery("namedQueryGetEventsByUserId");
		q.setInteger("id", id);
		List<Event> e = q.list();
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return e;
	}
	
	@Override
	public Event getEventById(int id) {
		Session s = sessionFactory.getCurrentSession();
		Event e = (Event) s.get(Event.class, id);
		if(s.isOpen()) {
			s.close();
		}
		return e;
	}
	
	@Override
	public int addEvent(Event e) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(e);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return result;
	}

	@Override
	public void updateEvent(Event e) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(e);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		
	}

	@Override
	public void deleteEvent(Event e) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(e);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
	}

}

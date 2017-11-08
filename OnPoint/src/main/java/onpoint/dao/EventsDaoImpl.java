package onpoint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import onpoint.beans.Events;

@Transactional
@Component(value="eventsDao")
@Scope(value="prototype")
public class EventsDaoImpl implements EventsDao {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Events> namedQueryGetEventsByUserId(int id){
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.getNamedQuery("namedQueryGetEventsByUserId");
		q.setInteger("id", id);
		List<Events> e = q.list();
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return e;
	}
	
	@Override
	public Events getEventById(int id) {
		Session s = sessionFactory.getCurrentSession();
		Events e = (Events) s.get(Events.class, id);
		if(s.isOpen()) {
			s.close();
		}
		return e;
	}
	
	@Override
	public int addEvent(Events e) {
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
	public void updateEvent(Events e) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(e);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		
	}

	@Override
	public void deleteEvent(Events e) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(e);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
	}

}

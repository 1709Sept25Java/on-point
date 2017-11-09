package com.revature.dao;

import com.revature.beans.Weather;

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

@Transactional
@Component(value="weatherDao")
@Scope(value="prototype")
public class WeatherDaoImpl implements WeatherDao{

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public Weather namedQueryGetWeatherPreference(int id) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query q = s.getNamedQuery("namedQueryGetWeatherPreference");
		q.setInteger("id", id);
		List<Weather> w = q.list();
		Iterator<Weather> itr = w.iterator();
		Weather we = itr.next();
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return we;
	}
	
	@Override
	public int addWeather(Weather w) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(w);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		return result;
	}

	@Override
	public void updateWeather(Weather w) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.merge(w);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
	}

	@Override
	public void deleteWeather(Weather w) {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		s.delete(w);
		tx.commit();
		if(s.isOpen()) {
			s.close();
		}
		
	}

}

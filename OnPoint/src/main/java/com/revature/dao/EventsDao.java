package com.revature.dao;

import java.util.List;

import com.revature.beans.Events;

public interface EventsDao {

	public List<Events> namedQueryGetEventsByUserId(int id);
	
	public Events getEventById(int id);
	
	public int addEvent(Events e);
	
	public void updateEvent(Events e);
	
	public void deleteEvent(Events e);
}

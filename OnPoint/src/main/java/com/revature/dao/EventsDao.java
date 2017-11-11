package com.revature.dao;

import java.util.List;

import com.revature.beans.Event;

public interface EventsDao {

	public List<Event> namedQueryGetEventsByUserId(int id);
	
	public Event getEventById(int id);
	
	public int addEvent(Event e);
	
	public void updateEvent(Event e);
	
	public void deleteEvent(Event e);
}

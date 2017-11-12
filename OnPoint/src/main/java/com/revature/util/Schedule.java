package com.revature.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Schedule {
	private List<Event> events;
	
	private Schedule() {
		events = new ArrayList<>();
	}
	
	private static Schedule schedule;
	
	public static Schedule getSchedule() {
		if (schedule==null) {
			schedule = new Schedule();
		}
		return schedule;
	}
		
	public boolean isEmpty() {
		return schedule.events.isEmpty();
	}
	
	public Event currentEvent(Date now) {
		Event e = null;
		System.out.println(now);
		for (Iterator<Event> iterator = schedule.events.iterator(); iterator.hasNext() ;) {
			e = iterator.next();
			if (e.compareDate(now) == true) {
				iterator.remove();
				return e;
			}
		}
		return null;
	}
	
	public void add(Event e) {
		schedule.events.add(e);
	}
	
}

package com.revature.util;

import java.util.Stack;

public class Schedule {
	private Stack<Event> events;
	
	private Schedule() {
		events = new Stack<>();
	}
	
	private static Schedule schedule;
	
	public static Schedule getSchedule() {
		if (schedule==null) {
			schedule = new Schedule();
		}
		return schedule;
	}
		
	public boolean isEmpty() {
		return schedule.events.empty();
	}
	
	public Event pop() {
		return schedule.events.pop();
	}
	
	public void add(Event e) {
		schedule.events.push(e);
	}
	
}

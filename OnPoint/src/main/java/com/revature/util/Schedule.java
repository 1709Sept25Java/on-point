package com.revature.util;

import java.util.Stack;

public class Schedule {
	private Stack<Event> events;
	
	public boolean isEmpty() {
		return events.empty();
	}
	
	public Event pop() {
		return events.pop();
	}
	
	public void add(Event e) {
		events.push(e);
	}
}

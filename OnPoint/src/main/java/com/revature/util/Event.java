package com.revature.util;

public class Event {
	public Event(String date, String description, String type) {
		super();
		this.date = date;
		this.description = description;
		this.type = type;
	}
	String date;
	String description;
	String type; //single or recurrent
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

package com.revature.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	public Boolean compareDate(Date now) {
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //String current = sdf.format(now);
		try {
			SimpleDateFormat format;

			//Date scheduled = format.parse(date);
			
	        //System.out.println("now: " + scheduled + "\n date: "+date); 
			if(type=="single") {
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date singleTime = format.parse(date);
				if (singleTime.before(now) || singleTime.equals(now)) {
					return true;
				}
			}else {
				//Calendar calendar = Calendar.getInstance();
				//format = new SimpleDateFormat("HH:mm:ss");
				String rDate = date + ":00";
				SimpleDateFormat  sdf = new SimpleDateFormat("HH:mm:ss");
				Date recurrentTime = sdf.parse(rDate);
				//Calendar calendar = Calendar.getInstance();
				now = sdf.parse(sdf.format(now));
				if (recurrentTime.before(now) || recurrentTime.equals(now)) {
					System.out.println("Recurrent: " + rDate + " " + now);
					return true;
				}
			}
			
//	        if (scheduled.before(now) || scheduled.equals(now)) {
//				return true;
//			}
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
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

	@Override
	public String toString() {
		return "Event [date=" + date + ", description=" + description + ", type=" + type + "]";
	}
}

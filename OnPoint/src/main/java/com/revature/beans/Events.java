package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("events")
@Scope("prototype")
@Entity
@Table(name="OP_EVENTS")
@NamedQueries({
	@NamedQuery(
			name = "namedQueryGetEventsByUserId",
			query = "from Events e where e.u_id = :id" //use class name and not table 
			)
})
public class Events implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="opEventsSequence")
	@SequenceGenerator(allocationSize=1,name="opEventsSequence",sequenceName="SQ_OP_EVENTS_PK")
	@Column(name="EVENT_ID")
	private int e_id;
	
	@Column(name="USER_ID")
	private int u_id;
	
	@Column(name="EVENT_DATE")
	private String event_date;
	
	@Column(name="EVENT_TIME")
	private String event_time;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	public int getId() {
		return e_id;
	}
	public void setId(int id) {
		this.e_id = id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getDate() {
		return event_date;
	}
	public void setDate(String date) {
		this.event_date = date;
	}
	public String getTime() {
		return event_time;
	}
	public void setTime(String time) {
		this.event_time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Events() {
		super();
	}
	public Events(int e_id, int u_id, String date, String time, String location, String description) {
		super();
		this.e_id = e_id;
		this.u_id = u_id;
		this.event_date = date;
		this.event_time = time;
		this.location = location;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Events [e_id=" + e_id + ", u_id=" + u_id + ", date=" + event_date + ", time=" + event_time + ", location="
				+ location + ", description=" + description + "]";
	}
	public Events(String event_time, String description) {
		super();
		this.event_time = event_time;
		this.description = description;
	}
	
	
}

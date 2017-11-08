package com.revature.beans;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="OP_EVENTS")
public class Events implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="opEventsSequence")
	@SequenceGenerator(allocationSize=1,name="opEventsSequence",sequenceName="SQ_OP_EVENTS_PK")
	@Column(name="EVENT_ID")
	private int e_id;
	
	@Column(name="USER_ID", nullable = false)
	private int u_id;
	
	@Column(name="DATE", nullable = false)
	private String date;
	
	@Column(name="TIME", nullable = false)
	private String time;
	
	@Column(name="LOCATION", nullable = false)
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
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Events [e_id=" + e_id + ", u_id=" + u_id + ", date=" + date + ", time=" + time + ", location="
				+ location + ", description=" + description + "]";
	}
	
	
}

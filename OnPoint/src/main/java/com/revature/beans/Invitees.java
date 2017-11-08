package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("invitees")
@Scope("prototype")
@Entity 
@Table(name="OP_INVITEES")

@NamedQueries({
	@NamedQuery(
			name = "namedQueryGetInviteesByEventId",
			query = "from Invitees i where i.e_id = :id" //use class name and not table 
			)
})
public class Invitees implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="opInviteesSequence")
	@SequenceGenerator(allocationSize=1,name="opInviteesSequence",sequenceName="SQ_OP_INVITEES_PK")
	@Column(name="INVITEE_ID")
	private int i_id;
	
	@Column(name="EVENT_ID", nullable = false)
	private int e_id;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="PHONE_NUMBER", nullable = false)
	private String phone_number;
	
	public int getI_id() {
		return i_id;
	}
	public void setI_id(int i_id) {
		this.i_id = i_id;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "Invitees [i_id=" + i_id + ", e_id=" + e_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", phone_number=" + phone_number + "]";
	}
	
	
}

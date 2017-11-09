package com.revature.dao;

import java.util.List;

import com.revature.beans.Invitees;

public interface InviteesDao {

	public List<Invitees> namedQueryGetInviteesByEventId(int id);
	
	public Invitees getInviteeById(int id);
	
	public int addInvitee(Invitees i);
	
	public void updateInvitee(Invitees i);
	
	public void deleteBat(Invitees i);
}

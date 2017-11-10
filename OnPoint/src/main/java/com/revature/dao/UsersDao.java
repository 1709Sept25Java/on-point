package com.revature.dao;

import java.util.List;

import com.revature.beans.Users;

public interface UsersDao {

	public boolean namedQueryisValidUsername(String username);
	
	public boolean namedQueryisValidPassword(String username, String password);
	
	public Users namedQueryGetUserByUsername(String username);
	
	public List<Users> getAllUsers();
	
	public int addUser(Users u);
	
	public void updateUser(Users u);
	
	public void deleteUser(Users u);
}

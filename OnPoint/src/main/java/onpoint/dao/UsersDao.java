package onpoint.dao;

import java.util.List;

import onpoint.beans.Users;

public interface UsersDao {

	public Users namedQueryGetUserByUsername(String username);
	
	public List<Users> getAllUsers();
	
	public int addUser(Users u);
	
	public void updateUser(Users u);
	
	public void deleteUser(Users u);
}

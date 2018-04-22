package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public boolean createUser(User user);
	public List<User> getUsers();
	public User getUser(String email) throws Exception;
	public boolean updateUser(String email);

}

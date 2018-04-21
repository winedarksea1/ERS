package com.revature.dao;

import java.util.List;

import com.revature.model.User;

public interface UserDao {
	
	public boolean createUser();
	public List<User> getUsers();
	public User getUser();
	public boolean updateUser();

}

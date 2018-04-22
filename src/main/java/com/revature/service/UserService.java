package com.revature.service;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.model.User;

public class UserService {
	private static UserService instance;
	private UserDaoImpl userDao;
	
	private UserService() {
		this.userDao = UserDaoImpl.getInstance();
	};
	
	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	public boolean createUser(User user) {
		return userDao.createUser(user);
	}
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	public User getUser(String email) {
		try {
			return userDao.getUser(email);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
			
	}
}

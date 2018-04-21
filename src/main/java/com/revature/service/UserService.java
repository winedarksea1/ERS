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
	
	public List<User> getUsers() {
		return userDao.getUsers();
	}
}

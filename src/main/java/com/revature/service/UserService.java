package com.revature.service;

import java.util.List;
import org.apache.log4j.Logger;

import com.revature.dao.UserDaoImpl;
import com.revature.model.User;

public class UserService {
	private static UserService instance;
	private UserDaoImpl userDao;
	private Logger log = Logger.getLogger(UserService.class);
	
	
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
		try {
			userDao.createUser(user);
			log.info("User " + user.getEmail() + " successfully created");
			return true;
		} catch (Exception e) {
			log.info("Exception Caught in User Service: " + e.getMessage());
			return false;
		}
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
	
	public User getUser(int id) {
		try {
			return userDao.getUser(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
			
	}
}

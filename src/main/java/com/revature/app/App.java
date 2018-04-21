package com.revature.app;

import com.revature.service.UserService;

import java.util.List;

import com.revature.model.User;

public class App {

	public static void main(String[] args) {
		UserService us = UserService.getInstance();
		
		List<User> users = us.getUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}

}

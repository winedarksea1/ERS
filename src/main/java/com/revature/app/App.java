package com.revature.app;

import com.revature.service.RequestService;
import com.revature.service.UserService;

import java.sql.Timestamp;
import java.util.List;

import com.revature.model.Request;
import com.revature.model.User;

public class App {

	public static void main(String[] args) {
		UserService us = UserService.getInstance();
		RequestService rs = RequestService.getInstance();
		
//		List<User> users = us.getUsers();
//		for (User user : users) {
//			System.out.println(user);
//		}
//		
//		Timestamp now = new Timestamp(System.currentTimeMillis());
//		System.out.println(now);
		
//		User user = us.getUser("tony_stark@gmail.com");
//		System.out.println("User: " + user);
		
		List<Request> requests = rs.getAllRequests();
		for (Request request : requests) {
			System.out.println(request);
		}
	}

}

package com.revature.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.RequestService;
import com.revature.service.UserService;
import com.revature.model.Request;
import com.revature.model.User;

public class RequestHelper {
	public static RequestService rs = RequestService.getInstance();
	public static UserService us = UserService.getInstance();
	
	public static List<Request> process(HttpServletRequest req) {
		
		String uri = req.getRequestURI();
		
		System.out.println(uri.substring(0, 37));
		System.out.println(uri.indexOf("/getAllRequests"));
		if (uri.equals("//ers-project/FrontController/request/getAllRequests.ajax")) {
			return getAllRequests();
		} else if (uri.equals("//ers-project/FrontController/request/getAllPendingRequests.ajax")) {
			return getAllPendingRequests();
		} else if (uri.equals("//ers-project/FrontController/request/getAllResolvedRequests.ajax")) {
			return getAllResolvedRequests();
		}
		

		return null;
	}
	
	public static List<User> processUserRequest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		if (uri.equals("//ers-project/FrontController/user/getUsers.ajax")) {
			return getUsers();
		} else if (uri.equals("//ers-project/FrontController/user.ajax")) {
			int id = Integer.parseInt(req.getParameter("user-id"));
			User user = us.getUser(id);
			List<User> users = new ArrayList<>();
			users.add(user);
			return users;
		}
		System.out.println("Parameter: " + req.getParameter("user-id"));
		return null;
	}
	
	public static List<Request> getAllRequests() {
		List<Request> requests = rs.getAllRequests();
		System.out.println(requests);
		return requests;
	}
	
	public static List<Request> getAllPendingRequests() {
		List<Request> requests = rs.getAllPendingRequests();
		System.out.println(requests);
		return requests;
	}
	
	public static List<Request> getAllResolvedRequests() {
		List<Request> requests = rs.getAllResolvedRequests();
		System.out.println(requests);
		return requests;
	};
	
	public static List<User> getUsers() {
		List<User> users = us.getUsers();
		System.out.println(users);
		return users;
	}
	
	public static User getUser() {
		int id = 2;
		User user = us.getUser(id);
		System.out.println(user);
		return user;
	}
}

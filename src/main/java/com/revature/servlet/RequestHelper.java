package com.revature.servlet;

import java.io.BufferedReader;
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
		} else if (uri.equals("//ers-project/FrontController/request.ajax")) {
			int id = Integer.parseInt(req.getParameter("request-id"));
			Request request = rs.viewRequest(id);
			List<Request> requests = new ArrayList<>();
			requests.add(request);
			return requests;
		}
		return null;
	}
	
	public static List<User> processUserGetRequest(HttpServletRequest req) {
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
	
	public static boolean processNewUserPostRequest(HttpServletRequest req) {
		System.out.println("Request");
		System.out.println(req);
		User user = new User(
				req.getParameter("email"),
				req.getParameter("userName"),
				req.getParameter("password1"),
				req.getParameter("firstName"),
				req.getParameter("lastName")
				);
//		
		return us.createUser(user);
//		ArrayList al = new ArrayList();
//		 StringBuffer jb = new StringBuffer();
//		  String line = null;
//		  try {
//		    BufferedReader reader = req.getReader();
//		    while ((line = reader.readLine()) != null)
//		      jb.append(line);
//		    al.add(line);
//		  } catch (Exception e) { /*report an error*/ }
//		  System.out.println(line);
//		  System.out.println(al);
//		return false;
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

package com.revature.servlet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		} else if (uri.equals("//ers-project/FrontController/request/getAllPendingRequestsForEmployee.ajax")) {
			int id = Integer.parseInt(req.getParameter("user-id"));
			return getAllPendingRequestsForEmployee(id);
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
	
	public static HashMap processPostNewRequest (HttpServletRequest req) {
		User user = us.getUser(req.getParameter("email"));
		double requestAmount = Double.parseDouble(req.getParameter("requestAmount"));
		Request request = new Request(
				requestAmount,
				user.getId(),
				1,
				0,
				req.getParameter("purpose")
				);
		boolean status = rs.submitRequest(request);
		HashMap hm = new HashMap();
		hm.put("status", status);
		hm.put("id", user.getId());
		return hm;
	}
	
	public static HashMap processCloseRequest(HttpServletRequest req, HttpServletResponse res) {
		String requestIdString = req.getParameter("requestId");
		int requestId = Integer.parseInt(requestIdString);
		int reviewerId = Integer.parseInt(req.getParameter("reviewerId"));
		String approvedStatus = req.getParameter("approved");
		String deniedStatus = req.getParameter("denied");
		HashMap hm = new HashMap();
		hm.put("requestId", requestId);
		hm.put("reviewerId", reviewerId);
		
		System.out.println("Request Id: " + requestId);
		System.out.println("Approved Status: " + approvedStatus);
		System.out.println("Denied Status: " + deniedStatus);
		
		if (approvedStatus != null) {
			if (approvedStatus.equals("on")) {
				rs.approveRequest(requestId);
				hm.put("status", "approved");
			
		}
		} else if (deniedStatus != null) {
			if (deniedStatus.equals("on")) {
				rs.denyRequest(requestId);
				hm.put("status", "denied");
				
			}
		}

		return hm;
	}
	
	public static HashMap processLogin(HttpServletRequest req) {
		User user = us.getUser(req.getParameter("email"));
		if (!req.getParameter("password").equals(user.getPassword())) {
			return null;
		} else {
			HashMap hm = new HashMap();
			if (user.isManager()) {
				hm.put("status", 1);
				hm.put("id", user.getId());
				return hm;
			} else {
				hm.put("status", 2);
				hm.put("id", user.getId());
				return hm;
			}
		}
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
	
	public static List<Request> getAllPendingRequestsForEmployee(int id) {
		return rs.getAllPendingRequestsForEmployee(id);
	}
	
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

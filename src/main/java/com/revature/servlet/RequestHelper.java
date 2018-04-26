package com.revature.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.RequestService;

import com.revature.model.Request;

public class RequestHelper {
	public static RequestService rs = RequestService.getInstance();
	
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
}

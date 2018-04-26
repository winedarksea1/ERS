package com.revature.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.RequestService;

import com.revature.model.Request;

public class RequestHelper {
	public static RequestService rs = RequestService.getInstance();
	
	public static String process(HttpServletRequest req) {
		
		String uri = req.getRequestURI();
		
		
		if (uri.equals("//ers-project/FrontController/getAllRequests.ajax")) {
			getAllRequests();
			return "getAllRequests called!";
		}
		
//		getAllRequests();

		return req.getRequestURI();
	}
	
	public static List<Request> getAllRequests() {
		List<Request> requests = rs.getAllRequests();
		System.out.println(requests);
		return requests;
	}
}

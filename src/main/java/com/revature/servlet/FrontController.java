package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.revature.model.Request;
import com.revature.service.RequestService;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		System.out.println("Hello From GET");
		System.out.println("slice " + request.getRequestURI().substring(0, 34));
		System.out.println("URL: " + request.getRequestURI());
		if (uri.contains("//ers-project/FrontController/request")) {
			mapper.writeValue(pw, RequestHelper.process(request));
		} else if (uri.contains("//ers-project/FrontController/user")) {
			mapper.writeValue(pw, RequestHelper.processUserGetRequest(request));
		} 

		pw.flush();
		
//		
//		RequestService rs = RequestService.getInstance();
//		List<Request> requests = rs.getAllPendingRequests();
//		for (Request req : requests) {
//			System.out.println(req);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		PrintWriter pw = response.getWriter();
		if (uri.contains("//ers-project/FrontController/user")) {
//			System.out.println("Was user successfully created: " + RequestHelper.processNewUserPostRequest(request));
			if (RequestHelper.processNewUserPostRequest(request)) {
				pw.write("<html>" +
						"<body>" +
						"<h1>Successfully Logged In</h1>" +
						"<a href='file:///Users/andrewmcgovern/Desktop/front_end_ERS/html/request-index-view.html'>Dashboard</a>"
						+ "</body></html>");
				pw.flush();
			}
		} else if (uri.contains("//ers-project/FrontController/login")) {
			if (RequestHelper.processLogin(request) == null) {
				pw.write("<html><body>" + 
							"<h1>Password was invalid</h1>" + 
							"<a href='file:///Users/andrewmcgovern/Desktop/front_end_ERS/html/sign-in.html'>Back to Login Page</a>" +
							"</body></html>");
				pw.flush();
			} else {
				HashMap hm = RequestHelper.processLogin(request);
				int status = (int) hm.get("status");
				int intId = (int) hm.get("id");
				String id = Integer.toString(intId);
				if (status == 1) {
					pw.write("<html><body>" + 
							"<h1>Login Successful</h1>" + 
							"<a href='file:///Users/andrewmcgovern/Desktop/front_end_ERS/html/request-index-view-manager.html?id=" +
							id + "'>"
							+ "Go to Manager Dashboard</a>" +
							"</body></html>");
					pw.flush();
				} else {
					pw.write("<html><body>" + 
							"<h1>Login Successful</h1>" + 
							"<a href='file:///Users/andrewmcgovern/Desktop/front_end_ERS/html/employee-homepage.html?id=" +
							id + "'>"
							+ "Go to Employee Dashboard</a>" +
							"</body></html>");
					pw.flush();
				}
			}
		} else if (uri.contains("//ers-project/FrontController/postNewRequest")) {
			HashMap hm = RequestHelper.processPostNewRequest(request);
			boolean status = (boolean) hm.get("status");
			int id = (int) hm.get("id");
			if (!status) {
				pw.write("<html>" +
						"<body>" +
						"<h1>Request submission was not successful</h1>" +
						"<a href='file:///Users/andrewmcgovern/Desktop/front_end_ERS/html/request-form.html?id=" +
						id + 
						"'>Return to Request Page</a>"
						+ "</body></html>");
				pw.flush();	
				} else {
					pw.write("<html>" +
							"<body>" +
							"<h1>Request submission successful!!!</h1>" +
							"<a href='file:///Users/andrewmcgovern/Desktop/front_end_ERS/html/employee-homepage.html?id=" +
							id + 
							"'>Return to Request Page</a>"
							+ "</body></html>");
					pw.flush();	
				}
		}
	}

}

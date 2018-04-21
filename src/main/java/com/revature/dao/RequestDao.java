package com.revature.dao;

import java.util.List;

import com.revature.model.Request;

public interface RequestDao {
	public boolean submitRequest();
	public Request viewRequest();
	public List<Request> getAllRequests();
	public List<Request> getAllPendingRequests();
	public List<Request> getAllResolvedRequests();
	public Request getSingleRequestForEmployee(String email);
	public List<Request> getAllRequestsForEmployee(String email);
	public List<Request> getAllPendingRequestsForEmployee(String email);
	public List<Request> getAllResolvedRequestsForEmployee();
	public String getRequestImage();
}

package com.revature.dao;

import java.util.List;

import com.revature.exception.RequestDoesNotExistException;
import com.revature.model.Request;

public interface RequestDao {
	public boolean submitRequest(Request request);
	public Request viewRequest(int id) throws RequestDoesNotExistException;
	public List<Request> getAllRequests();
	public List<Request> getAllPendingRequests();
	public List<Request> getAllResolvedRequests();
	public Request getSingleRequestForEmployee(int id);
	public List<Request> getAllRequestsForEmployee(int id);
	public List<Request> getAllPendingRequestsForEmployee(int id);
	public List<Request> getAllResolvedRequestsForEmployee(int id);
	public String getRequestImage();
	public boolean approveRequest(int id);
	public boolean denyRequest(int id);
}

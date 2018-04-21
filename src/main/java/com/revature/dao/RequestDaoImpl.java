package com.revature.dao;

import java.util.List;

import com.revature.model.Request;

public class RequestDaoImpl implements RequestDao {
	
	private static RequestDaoImpl instance;
	
	private RequestDaoImpl() {}
	
	public static RequestDaoImpl getInstance() {
		if (instance == null) {
			instance = new RequestDaoImpl();
		}
		return instance;
	}

	@Override
	public boolean submitRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Request viewRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request getSingleRequestForEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllRequestsForEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllPendingRequestsForEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> getAllResolvedRequestsForEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestImage() {
		// TODO Auto-generated method stub
		return null;
	}

}

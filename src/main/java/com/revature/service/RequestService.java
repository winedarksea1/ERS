package com.revature.service;

import java.util.List;

import com.revature.dao.RequestDaoImpl;
import com.revature.model.Request;

public class RequestService {
	private static RequestService instance;
	private RequestDaoImpl requestDao;
	
	private RequestService() {
		this.requestDao = RequestDaoImpl.getInstance();
	}
	
	public static RequestService getInstance() {
		if (instance == null) {
			instance = new RequestService();
		}
		return instance;
	}
	
	public List<Request> getAllRequests() {
		return requestDao.getAllRequests();
	}
}

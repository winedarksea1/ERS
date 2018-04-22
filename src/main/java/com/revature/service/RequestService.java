package com.revature.service;

import com.revature.dao.RequestDaoImpl;

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
}

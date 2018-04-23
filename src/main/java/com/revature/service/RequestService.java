package com.revature.service;

import java.util.List;
import org.apache.log4j.Logger;

import com.revature.dao.RequestDaoImpl;
import com.revature.exception.RequestDoesNotExistException;
import com.revature.model.Request;

public class RequestService {
	private static RequestService instance;
	private RequestDaoImpl requestDao;
	private Logger log = Logger.getLogger(RequestService.class);
	
	private RequestService() {
		this.requestDao = RequestDaoImpl.getInstance();
	}
	
	public static RequestService getInstance() {
		if (instance == null) {
			instance = new RequestService();
		}
		return instance;
	}
	
	public boolean submitRequest(Request request) {
		return requestDao.submitRequest(request);
	}
	
	public Request viewRequest(int id) {
		try {
			return requestDao.viewRequest(id);
		} catch(RequestDoesNotExistException e) {
			log.info("=====>> Exception caught in Request Service: " + e.getMessage());
			return null;
		}
	}
	
	public List<Request> getAllRequests() {
		return requestDao.getAllRequests();
	}
	
	public List<Request> getAllPendingRequests() {
		return requestDao.getAllPendingRequests();
	}
	
	public List<Request> getAllResolvedRequests() {
		return requestDao.getAllResolvedRequests();
	}
	
	public List<Request> getAllRequestsForEmployee(int id) {
		return requestDao.getAllRequestsForEmployee(id);
	}
	
	public List<Request> getAllPendingRequestsForEmployee(int id) {
		return requestDao.getAllPendingRequestsForEmployee(id);
	}
	
	public List<Request> getAllResolvedRequestsForEmployee(int id) {
		return requestDao.getAllResolvedRequestsForEmployee(id);
	}
	
	public boolean approveRequest(int id) {
		return requestDao.approveRequest(id);
	}
	
	public boolean denyRequest(int id) {
		return requestDao.denyRequest(id);
	}
}

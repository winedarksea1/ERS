package com.revature.exception;

public class RequestDoesNotExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Request Does Not Exist";
	}
}

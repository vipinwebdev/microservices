package com.vip.user.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("Resource not found. ");
	}
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}

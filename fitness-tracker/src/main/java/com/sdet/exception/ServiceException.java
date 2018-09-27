package com.sdet.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6279767102828987119L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(final String message) {
		super(message);
	}
}

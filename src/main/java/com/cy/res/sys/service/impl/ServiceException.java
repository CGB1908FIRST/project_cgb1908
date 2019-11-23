package com.cy.res.sys.service.impl;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1681560894771073923L;
	public ServiceException() {
		super();
	}
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(Throwable cause) {
		super(cause);
	}
	
}

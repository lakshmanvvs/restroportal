package com.restro.exceptions;

public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3768309062774662761L;
	
	public AppException (String msg) {
		super(msg);
	}
	
	public AppException (String msg, Throwable cause) {
		super(msg, cause);
	}

}

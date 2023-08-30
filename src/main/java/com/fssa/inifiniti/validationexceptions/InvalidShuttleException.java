package com.fssa.inifiniti.validationexceptions;

public class InvalidShuttleException extends Exception {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidShuttleException(String msg) {
		super(msg);
	}
	
	public InvalidShuttleException(Throwable e) {
		super(e);
	}

}

package com.fssa.inifiniti.validationexceptions;

public class InvalidCompanyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCompanyException(String msg) {
		super(msg);
	}
	
	public InvalidCompanyException(Throwable e) {
		super(e);
	}

}

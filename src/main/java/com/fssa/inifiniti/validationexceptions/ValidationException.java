package com.fssa.inifiniti.validationexceptions;

public class ValidationException extends Exception{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  ValidationException(String msg) {	
		super(msg);
	}
	
	public  ValidationException(Throwable e) {	
		super(e);
	}

}

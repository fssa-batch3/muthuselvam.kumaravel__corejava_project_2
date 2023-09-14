package com.fssa.inifiniti.validationexceptions;

/**
 * The ValidationException class is a generic exception used to indicate that a validation operation
 * failed due to invalid data or conditions.
 */

public class ValidationException extends Exception{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 /**
     * Constructs a new ValidationException with the specified detail message.
     *
     * @param msg The detail message explaining the reason for the exception.
     */
	
	public  ValidationException(String msg) {	
		super(msg);
	}
	
	/**
     * Constructs a new ValidationException with the specified cause and a detail message of
     * (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
     *
     * @param e The cause of the exception.
     */
	
	public  ValidationException(Throwable e) {	
		super(e);
	}

}

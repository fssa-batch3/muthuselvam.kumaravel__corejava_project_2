package com.fssa.inifiniti.validationexceptions;

/**
 * The InvalidCompanyException class is an exception used to indicate that a company-related operation
 * failed due to invalid data or conditions.
 */

public class InvalidCompanyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 /**
     * Constructs a new InvalidCompanyException with the specified detail message.
     *
     * @param msg The detail message explaining the reason for the exception.
     */
	
	public InvalidCompanyException(String msg) {
		super(msg);
	}
	
	 /**
     * Constructs a new InvalidCompanyException with the specified cause and a detail message of
     * (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
     *
     * @param e The cause of the exception.
     */
	
	public InvalidCompanyException(Throwable e) {
		super(e);
	}

}

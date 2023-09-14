package com.fssa.inifiniti.validationexceptions;

/**
 * The InvalidUserException class is an exception used to indicate that a user-related operation
 * failed due to invalid data or conditions.
 */

public class InvalidUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3646340677981984453L;

	/**
     * Constructs a new InvalidUserException with the specified detail message.
     *
     * @param msg The detail message explaining the reason for the exception.
     */
	
	public  InvalidUserException(String msg) {	
		super(msg);
	}
	
	 /**
     * Constructs a new InvalidUserException with the specified cause and a detail message of
     * (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
     *
     * @param e The cause of the exception.
     */
	public  InvalidUserException(Throwable e) {	
		super(e);
	}
}

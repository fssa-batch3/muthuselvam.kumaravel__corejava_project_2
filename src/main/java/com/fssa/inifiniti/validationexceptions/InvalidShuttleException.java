package com.fssa.inifiniti.validationexceptions;

/**
 * The InvalidShuttleException class is an exception used to indicate that a shuttle-related operation
 * failed due to invalid data or conditions.
 */

public class InvalidShuttleException extends Exception {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 /**
     * Constructs a new InvalidShuttleException with the specified detail message.
     *
     * @param msg The detail message explaining the reason for the exception.
     */
	
	public InvalidShuttleException(String msg) {
		super(msg);
	}
	
	 /**
     * Constructs a new InvalidShuttleException with the specified cause and a detail message of
     * (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
     *
     * @param e The cause of the exception.
     */
	
	public InvalidShuttleException(Throwable e) {
		super(e);
	}

}

package com.fssa.inifiniti.services.exceptions;

/**
 * The ServiceException class represents an exception specific to service operations.
 * This exception can be used to indicate errors or exceptional conditions that occur during service operations.
 */

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1224472535939295348L;

	 /**
     * Constructs a new ServiceException with the specified error message.
     *
     * @param msg The error message associated with this exception.
     */
	
	public ServiceException( String msg) {
		super(msg);
	}

	/**
     * Constructs a new ServiceException with the specified cause (another throwable) and a detail message.
     *
     * @param e The cause of this exception.
     */
	
	public ServiceException( Throwable e) {
		super(e);
	}
	

} 

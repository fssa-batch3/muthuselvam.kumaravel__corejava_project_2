package com.fssa.inifiniti.validationexceptions;

/**
 * The InvalidBookingException class is an exception used to indicate that a booking-related operation
 * failed due to invalid data or conditions.
 */

public class InvalidBookingException extends Exception{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8483007833434083423L;

	/**
     * Constructs a new InvalidBookingException with the specified detail message.
     *
     * @param msg The detail message explaining the reason for the exception.
     */
	
	public InvalidBookingException(String msg) {
		super(msg);
	}
	
	 /**
     * Constructs a new InvalidBookingException with the specified cause and a detail message of
     * (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
     *
     * @param e The cause of the exception.
     */
	
	public InvalidBookingException(Throwable e) {
		super(e);
	}
}
 
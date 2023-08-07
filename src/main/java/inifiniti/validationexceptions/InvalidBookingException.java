package inifiniti.validationexceptions;

public class InvalidBookingException extends Exception{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8483007833434083423L;

	public InvalidBookingException(String msg) {
		super(msg);
	}
	
	public InvalidBookingException(Throwable e) {
		super(e);
	}
}

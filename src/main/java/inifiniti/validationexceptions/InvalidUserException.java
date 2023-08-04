package inifiniti.validationexceptions;

public class InvalidUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3646340677981984453L;

	public  InvalidUserException(String msg) {	
		super(msg);
	}
	
	public  InvalidUserException(Throwable e) {	
		super(e);
	}
}

package inifiniti.services.exceptions;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1224472535939295348L;

	public ServiceException( String msg) {
		super(msg);
	}

	public ServiceException( Throwable e) {
		super(e);
	}
	

}

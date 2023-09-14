package com.fssa.inifiniti.dao.exceptions;

/**
 * This exception is used to indicate errors that occur in the DAO (Data Access Object) layer
 * of the application, such as database access or data retrieval problems.
 */

public class DaoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8754097875540075804L;

	 /**
     * Constructs a new DaoException with the specified detail message.
     *
     * @param msg The detail message explaining the cause of the exception.
     */
	
	public DaoException(String msg) {
		super(msg);
	}

	 /**
     * Constructs a new DaoException with the specified cause.
     *
     * @param e The underlying cause of this exception.
     */
	
	public DaoException(Throwable e) {
		super(e);
	}
}
 
package com.fssa.inifiniti.dao.exceptions;

public class DaoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8754097875540075804L;


	public DaoException(String msg) {
		super(msg);
	}

	
	public DaoException(Throwable e) {
		super(e);
	}
}

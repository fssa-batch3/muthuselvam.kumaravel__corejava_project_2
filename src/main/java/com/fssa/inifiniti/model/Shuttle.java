package com.fssa.inifiniti.model;

/**
 * The Shuttle class represents information about a shuttle service, including its shuttle ID, company name, date, and time.
 */
public class Shuttle {
	

	/**
	 * The unique identifier of the shuttle service.
	 */
	private int shuttleId;
	
	/**
	 * The name of the company operating the shuttle service.
	 */
	private String companyName;
	
	/**
	 * The date when the shuttle service is scheduled.
	 */
	private String date;
	
	/**
	 * The time when the shuttle service is scheduled.
	 */
	private String time;
	
	/**
	 * Constructs a new Shuttle object with the specified shuttle ID, company name, date, and time.
	 *
	 * @param shuttleId    The unique identifier of the shuttle service.
	 * @param companyName  The name of the company operating the shuttle service.
	 * @param date         The date when the shuttle service is scheduled.
	 * @param time         The time when the shuttle service is scheduled.
	 */
	
	public Shuttle(int shuttleId, String companyName, String date, String time) {
		this.shuttleId = shuttleId;
		this.companyName = companyName;
		this.date = date;
		this.time = time;
	}
	
	/**
	 * Default constructor for Shuttle.
	 */
	
	public Shuttle() {
		
	} 
	
	/**
	 * Gets the shuttle ID.
	 *
	 * @return The unique identifier of the shuttle service.
	 */
	
	public int getShuttleId() {
		return shuttleId;
	}
	
	/**
	 * Sets the shuttle ID.
	 *
	 * @param shuttleId The unique identifier of the shuttle service.
	 */
	
	public void setShuttleId(int shuttleId) {
		this.shuttleId = shuttleId;
	}
	
	/**
	 * Gets the date when the shuttle service is scheduled.
	 *
	 * @return The date when the shuttle service is scheduled.
	 */
	
	public String getDate() {
		return date;
	}
	
	/**
	 * Sets the date when the shuttle service is scheduled.
	 *
	 * @param date The date when the shuttle service is scheduled.
	 */
	
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Gets the time when the shuttle service is scheduled.
	 *
	 * @return The time when the shuttle service is scheduled.
	 */
	
	public String getTime() {
		return time;
	}
	
	/**
	 * Sets the time when the shuttle service is scheduled.
	 *
	 * @param time The time when the shuttle service is scheduled.
	 */
	
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * Gets the company name operating the shuttle service.
	 *
	 * @return The name of the company operating the shuttle service.
	 */
	
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Sets the company name operating the shuttle service.
	 *
	 * @param companyName The name of the company operating the shuttle service.
	 */
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

}

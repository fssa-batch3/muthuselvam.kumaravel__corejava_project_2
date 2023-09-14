package com.fssa.inifiniti.model;

/**
 * Represents a booking made by a user for a shuttle service.
 */

public class Booking {

	private int shuttleId;
	private String userName;
	private String destination;
	private String email;
	private int seatNum;
	private int changeSeatNum;
	private int bookingId;
	
	
	/**
	 * Initializes a new booking with the provided information.
	 *
	 * @param shuttleId The ID of the shuttle for the booking.
	 * @param userName The name of the user making the booking.
	 * @param email The email address of the user.
	 * @param destination The destination of the shuttle service.
	 * @param seatNum The seat number selected for the booking.
	 */
	public Booking(int shuttleId, String userName,String email, String destination, int seatNum) {
		this.shuttleId = shuttleId;
		this.userName = userName;
		this.destination = destination;
		this.email  = email;
		this.seatNum = seatNum;
	}
	 
	/**
	 * Initializes a new booking with the provided email address.
	 *
	 * @param email The email address of the user associated with the booking.
	 */
	
	public Booking(String email) {
		this.email = email;
	}
	
	/**
	 * Initializes a new booking with the provided shuttle ID and email address.
	 *
	 * @param shuttleId The ID of the shuttle for the booking.
	 * @param email The email address of the user associated with the booking.
	 */
	
	public Booking(int shuttleId, String email) {
		this.shuttleId= shuttleId;
		this.email=email;
	}
	
	/**
	 * Initializes a new booking with the provided shuttle ID, email address, seat number, and changed seat number.
	 *
	 * @param shuttleId The ID of the shuttle for the booking.
	 * @param email The email address of the user associated with the booking.
	 * @param seatNum The original seat number selected for the booking.
	 * @param changeSeatNum The new seat number selected for the booking.
	 */
	
	public Booking (int shuttleId , String email , int seatNum , int changeSeatNum) {
		this.shuttleId = shuttleId;
		this.email = email;
		this.seatNum = seatNum;
		this.changeSeatNum = changeSeatNum;
	}
	
	/**
	 * Initializes an empty booking with default values.
	 */
	
	public Booking() {
		
		
	}
	
	/**
	 * Gets the email address associated with the booking.
	 *
	 * @return The email address of the user.
	 */
	
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address associated with the booking.
	 *
	 * @param email The email address to set.
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the ID of the shuttle associated with the booking.
	 *
	 * @return The shuttle ID.
	 */
	
	public int getShuttleId() {
		return shuttleId;
	}
	
	/**
	 * Sets the ID of the shuttle associated with the booking.
	 *
	 * @param shuttleId The shuttle ID to set.
	 */
	
	public void setShuttleId(int shuttleId) {
		this.shuttleId = shuttleId;
	}
	
	/**
	 * Gets the name of the user associated with the booking.
	 *
	 * @return The user's name.
	 */
	
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the name of the user associated with the booking.
	 *
	 * @param userName The user's name to set.
	 */
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the destination of the shuttle service for the booking.
	 *
	 * @return The destination.
	 */
	
	public String getDestination() {
		return destination;
	}
	
	/**
	 * Sets the destination of the shuttle service for the booking.
	 *
	 * @param destination The destination to set.
	 */
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	 * Gets the seat number selected for the booking.
	 *
	 * @return The seat number.
	 */
	
	public int getSeatNum() {
		return seatNum;
	}
	
	/**
	 * Sets the seat number for the booking.
	 *
	 * @param seatNum The seat number to set.
	 */

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
	/**
	 * Gets the changed seat number (if any) for the booking.
	 *
	 * @return The changed seat number.
	 */
	
	public int getChangeSeatNum() {
		return changeSeatNum;
	}
	
	/**
	 * Sets the changed seat number (if any) for the booking.
	 *
	 * @param changeSeatNum The changed seat number to set.
	 */
	
	public void setChangeSeatNum(int changeSeatNum) {
		this.changeSeatNum = changeSeatNum;
	}

	/**
	 * Gets the booking ID associated with the booking.
	 *
	 * @return The booking ID.
	 */
	
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * Sets the booking ID associated with the booking.
	 *
	 * @param bookingId The booking ID to set.
	 */
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	@Override
	public String toString() {
		return "Booking [shuttleId=" + shuttleId + ", userName=" + userName + ", destination=" + destination
				+ ", email=" + email + ", seatNum=" + seatNum + ", changeSeatNum=" + changeSeatNum + "]";
	}

	
	
	
	
	

}

package com.fssa.inifiniti.model;

public class Booking {

	private int shuttleId;
	private String userName;
	private String destination;
	private String email;
	private int seatNum;
	private int changeSeatNum;
	
	public Booking(int shuttleId, String userName,String email, String destination, int seatNum) {
		this.shuttleId = shuttleId;
		this.userName = userName;
		this.destination = destination;
		this.email  = email;
		this.seatNum = seatNum;
	}
	
	public Booking(String email) {
		this.email = email;
	}
	
	public Booking(int shuttleId, String email) {
		this.shuttleId= shuttleId;
		this.email=email;
	}
	
	public Booking (int shuttleId , String email , int seatNum , int changeSeatNum) {
		this.shuttleId = shuttleId;
		this.email = email;
		this.seatNum = seatNum;
		this.changeSeatNum = changeSeatNum;
	}
	
	public Booking() {
		
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getShuttleId() {
		return shuttleId;
	}
	public void setShuttleId(int shuttleId) {
		this.shuttleId = shuttleId;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
	public int getChangeSeatNum() {
		return changeSeatNum;
	}

	public void setChangeSeatNum(int changeSeatNum) {
		this.changeSeatNum = changeSeatNum;
	}

	@Override
	public String toString() {
		return "Booking [shuttleId=" + shuttleId + ", userName=" + userName + ", destination=" + destination
				+ ", email=" + email + ", seatNum=" + seatNum + ", changeSeatNum=" + changeSeatNum + "]";
	}
	
	
	
	
	

}

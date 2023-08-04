package inifiniti.model;

public class Booking {

	private int shuttle_id;
	private String userName;
	private String destination;
	private int seatNum;
	
	public Booking(int shuttle_id, String userName, String destination, int seatNum) {
		this.shuttle_id = shuttle_id;
		this.userName = userName;
		this.destination = destination;
		this.seatNum = seatNum;
	}
	
	public Booking() {
		
		
	}
	
	
	public int getShuttle_id() {
		return shuttle_id;
	}
	public void setShuttle_id(int shuttle_id) {
		this.shuttle_id = shuttle_id;
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
	
	@Override
	public String toString() {
		return "Booking [shuttle_id=" + shuttle_id + ", userName=" + userName + ", destination=" + destination
				+ ", seatNum=" + seatNum + "]";
	}
	
	

}

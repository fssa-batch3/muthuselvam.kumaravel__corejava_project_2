package inifiniti.model;

public class Booking {

	private int shuttle_id;
	private String userName;
	private String destination;
	private String email;
	private int seatNum;
	private int changeSeatNum;
	
	public Booking(int shuttle_id, String userName,String email, String destination, int seatNum) {
		this.shuttle_id = shuttle_id;
		this.userName = userName;
		this.destination = destination;
		this.email  = email;
		this.seatNum = seatNum;
	}
	
	public Booking (int shuttle_id , String email , int seatNum , int changeSeatNum) {
		this.shuttle_id = shuttle_id;
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
	
	public int getChangeSeatNum() {
		return changeSeatNum;
	}

	public void setChangeSeatNum(int changeSeatNum) {
		this.changeSeatNum = changeSeatNum;
	}

	@Override
	public String toString() {
		return "Booking [shuttle_id=" + shuttle_id + ", userName=" + userName + ", destination=" + destination
				+ ", email=" + email + ", seatNum=" + seatNum + ", changeSeatNum=" + changeSeatNum + "]";
	}
	
	
	
	
	

}

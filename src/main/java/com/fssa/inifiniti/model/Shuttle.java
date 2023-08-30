package com.fssa.inifiniti.model;

public class Shuttle {
	
	
	

	private int shuttleId;
	private String companyName;
	private String date;
	private String time;
	
	
	public Shuttle(int shuttleId, String companyName, String date, String time) {
		this.shuttleId = shuttleId;
		this.companyName = companyName;
		this.date = date;
		this.time = time;
	}
	public Shuttle() {
		
	}
	
	public int getShuttleId() {
		return shuttleId;
	}
	public void setShuttleId(int shuttleId) {
		this.shuttleId = shuttleId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

}

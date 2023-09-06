package com.fssa.inifiniti.model;

public class User {

	private String userName;
	private String email;
	private String password;
	private boolean loggedIn ;
	private int id;

	public User(String username,String email , String password) {
		this.userName = username;
		this.password = password;
		this.email =email;
		
	}
	
	public User(String email , String password) {
		this.password = password;
		this.email =email;
	}
	
	public User() {
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + ","+" loggedIn=" + loggedIn + "]";
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

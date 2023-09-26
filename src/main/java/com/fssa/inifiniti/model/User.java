package com.fssa.inifiniti.model;

/**
 * The User class represents a user in the system with attributes such as username, email, password, logged-in status, and ID.
 */

public class User {

	
	/**
	 * The username of the user.
	 */
	private String userName;
	
	/**
	 * The email address of the user.
	 */
	private String email;
	

	/**
	 * The password of the user.
	 */
	private String password;
	
	/**
	 * Indicates whether the user is currently logged in.
	 */
	private boolean loggedIn ;
	
	/**
	 * The unique identifier (ID) of the user.
	 */
	private int id;
	
	private String firstName ; 
	private String lastName;
	private String location ;
	private String phoneNumber ; 
	private String salt;
	
	
	public User(String email, String firstName, String lastName, String location, String phoneNumber) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.phoneNumber = phoneNumber;
	}


	/**
	 * Constructs a new User object with the specified username, email, and password.
	 *
	 * @param username The username of the user.
	 * @param email    The email address of the user.
	 * @param password The password of the user.
	 */
	
	public User(String username,String email , String password) {
		this.userName = username;
		this.password = password;
		this.email =email;
		
	} 
	
	/**
	 * Constructs a new User object with the specified email and password.
	 *
	 * @param email    The email address of the user.
	 * @param password The password of the user.
	 */
	
	public User(String email , String password) {
		this.password = password;
		this.email =email;
	}
	
	/**
	 * Default constructor for User.
	 */
	public User() {
		
	}
	
	/**
	 * Gets the username of the user.
	 *
	 * @return The username of the user.
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the username of the user.
	 *
	 * @param userName The username of the user.
	 */
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the email address of the user.
	 *
	 * @return The email address of the user.
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email address of the user.
	 *
	 * @param email The email address of the user.
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the password of the user.
	 *
	 * @return The password of the user.
	 */
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password of the user.
	 *
	 * @param password The password of the user.
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Returns a string representation of the User object.
	 *
	 * @return A string representation of the User object.
	 */
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + ","+" loggedIn=" + loggedIn + "]";
	}

	/**
	 * Indicates whether the user is currently logged in.
	 *
	 * @return {@code true} if the user is logged in, {@code false} otherwise.
	 */
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Sets the logged-in status of the user.
	 *
	 * @param loggedIn {@code true} if the user is logged in, {@code false} otherwise.
	 */
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	/**
	 * Gets the unique identifier (ID) of the user.
	 *
	 * @return The ID of the user.
	 */
	
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier (ID) of the user.
	 *
	 * @param id The ID of the user.
	 */
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}
}

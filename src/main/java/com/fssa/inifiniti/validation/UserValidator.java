package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;
import com.fssa.inifiniti.validationexceptions.ValidationException;

/**
 * The UserValidator class provides methods for validating user-related information.
 * It includes methods for validating user names, email addresses, and passwords.
 */

public class UserValidator {
	
	/**
	 * Validates the login credentials of a user.
	 *
	 * @param email The user's email address.
	 * @param password The user's password.
	 * @return true if both email and password are valid, otherwise false.
	 * @throws ValidationException If either the email or password is invalid.
	 */
	
	public static boolean validateLoginUser(String email, String password) throws ValidationException {
		
		validateEmailNotNull(email);
		validatePasswordNotNull(password);
		validateEmail(email);
		validatePassword(password);
		
		return true;
	}
	
	/**
	 * Validates the attributes of a User object.
	 *
	 * @param user The User object to validate.
	 * @return true if all attributes of the User object are valid, otherwise false.
	 * @throws ValidationException If any attribute of the User object is invalid.
	 */
	
	public static boolean validateUser(User user) throws ValidationException {
	
		
		validateUserNotNull(user);
		validateName(user.getUserName());
		validateEmail(user.getEmail());
		validatePassword(user.getPassword());
		
		return true;
	}
	
	
	/**
	 * Validates that the email is not null.
	 *
	 * @param email The email to be validated.
	 * @return true if the email is not null, otherwise false.
	 * @throws ValidationException If the email is null.
	 */
	
	public static boolean validateEmailNotNull(String email) throws ValidationException {
		if(email == null) {
			throw new ValidationException("Email cannot be null");
		}
		return true;
	}
	
	/**
	 * Validates that the password is not null.
	 *
	 * @param password The password to be validated.
	 * @return true if the password is not null, otherwise false.
	 * @throws ValidationException If the password is null.
	 */
	
	public static boolean validatePasswordNotNull(String password) throws ValidationException {
		if(password == null) {
			throw new ValidationException("password cannot be null");
		}
		return true;
	}
	
	/**
	 * Validates that the user is not null.
	 *
	 * @param user The user to be validated.
	 * @return true if the user is not null, otherwise false.
	 * @throws ValidationException If the user is null.
	 */
	
	public static boolean validateUserNotNull(User user) throws ValidationException {
		if(user == null) {
			throw new ValidationException("User is null");
		}
		return true;
	}
	
	 /**
     * Validates a user's name, ensuring it contains only letters.
     *
     * @param name The name to be validated.
     * @return True if the name is valid; otherwise, false.
     * @throws ValidationException If the name contains characters other than letters.
     */

	
	public static  boolean validateName(String name) throws ValidationException {
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			if( m.matches()) {
				  return true;
			  }else {
				  throw new ValidationException("Name cannot contain other than letters");
			  }
	}
	
	 /**
     * Validates a user's password, checking for complexity requirements.
     *
     * @param password The password to be validated.
     * @return True if the password is complex enough; otherwise, false.
     * @throws ValidationException If the password complexity requirements are not met.
     */

	public static boolean validatePassword(String password) throws ValidationException {
			String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			
			if( Pattern.matches(patternString, password)) {
				  return true;
			  }else {
				  throw new ValidationException("Password must contain one uppercase , one lowercase , one special character , length of eight character");
			  }
	}
	
	 /**
     * Validates a user's email address.
     *
     * @param email The email address to be validated.
     * @return True if the email address is valid; otherwise, false.
     * @throws ValidationException If the email address is not in the correct format.
     */
	
	public static boolean validateEmail(String email) throws ValidationException {
	    if (email != null) {
	        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        
	        if (matcher.matches()) {
	            return true;
	        } else {
	            throw new ValidationException("Please enter a valid email address");
	        }
	    } else {
	        throw new ValidationException("Email cannot be null");
	    }
	}
	
	/**
     * Validates a user's email address and throws an exception if it is not valid.
     *
     * @param email The email address to be validated.
     * @throws InvalidUserException If the email address is not valid.
     */
	
	public boolean validateEmailId(String email) throws ValidationException {
	    if (email != null) {
	        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        
	        if (matcher.matches()) {
	            return true;
	        } else {
	            throw new ValidationException("Please enter a valid email address");
	        }
	    } else {
	        throw new ValidationException("Email cannot be null");
	    }
	}

}

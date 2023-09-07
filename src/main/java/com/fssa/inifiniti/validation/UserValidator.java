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
     * Validates a user's login credentials, including email and password.
     *
     * @param email    The email address to be validated.
     * @param password The password to be validated.
     * @return True if the login credentials are valid; otherwise, false.
     * @throws ValidationException If the login details are invalid.
     */
	
	public static boolean validateLoginUser(String email, String password) throws ValidationException {
		if( email!=null&& password!=null&&validateEmail(email)&&validatePassword(password)) {	
			return true;
		} else {
			
			throw new ValidationException("Login details are invalid");
		}
	}
	
	  /**
     * Validates a user, checking that the user's name, email, and password are valid.
     *
     * @param user The user to be validated.
     * @return True if the user is valid; otherwise, false.
     * @throws ValidationException If the user details are invalid.
     */
	
	public static boolean validateUser(User user) throws ValidationException {
		
		if( user!=null&&validateName(user.getUserName())&&validateEmail(user.getEmail())&&validatePassword(user.getPassword())) {
			
			return true;
		} else {
			
			throw new ValidationException("User details are invalid");
		}
		
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
	
	public static boolean validateEmailId(String email) throws ValidationException {
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

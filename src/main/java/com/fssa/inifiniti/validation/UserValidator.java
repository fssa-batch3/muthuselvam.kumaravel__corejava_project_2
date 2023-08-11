package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class UserValidator {
	
	public static boolean ValidateLoginUser(String email, String password) throws InvalidUserException {
		if( email!=null&& password!=null&&validateEmail(email)&&validatePassword(password)) {	
			return true;
		} else {
			
			throw new InvalidUserException("Login details are invalid");
		}
	}
	
	
	
	
	public static boolean validateUser(User user) throws InvalidUserException {
		
		if( user!=null&&validateName(user.getUserName())&&validateEmail(user.getEmail())&&validatePassword(user.getPassword())) {
			
			return true;
		} else {
			
			throw new InvalidUserException("User details are invalid");
		}
		
	}
	
	

	public static  boolean validateName(String name) throws InvalidUserException {
		boolean match = false;
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				return match;
			} else {
				throw new InvalidUserException("Invalid Username");
			}
		
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		
			String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(patternString, password);


			if (match) {
				return match;
			} else {
				throw new InvalidUserException("Invalid Password");
			}
		
	}

	public static  boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				return isMatch;
			} else {
				throw new InvalidUserException("Invalid Email");
			}
			
		
	}

}

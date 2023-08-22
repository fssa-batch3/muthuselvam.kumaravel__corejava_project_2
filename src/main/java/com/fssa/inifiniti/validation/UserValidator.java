package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class UserValidator {
	
	public static boolean validateLoginUser(String email, String password) throws InvalidUserException {
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
	
	

	public static  boolean validateName(String name) {
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			return m.matches();
	}

	public static boolean validatePassword(String password) {
			String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			return Pattern.matches(patternString, password);
	}

	public static  boolean validateEmail(String email){
			String regex = "^.*@.*\\..*$";
			return Pattern.matches(regex, email);		
	}

}

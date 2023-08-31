package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;
import com.fssa.inifiniti.validationexceptions.ValidationException;

public class UserValidator {
	
	public static boolean validateLoginUser(String email, String password) throws ValidationException {
		if( email!=null&& password!=null&&validateEmail(email)&&validatePassword(password)) {	
			return true;
		} else {
			
			throw new ValidationException("Login details are invalid");
		}
	}
	
	
	
	
	public static boolean validateUser(User user) throws ValidationException {
		
		if( user!=null&&validateName(user.getUserName())&&validateEmail(user.getEmail())&&validatePassword(user.getPassword())) {
			
			return true;
		} else {
			
			throw new ValidationException("User details are invalid");
		}
		
	}
	
	

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

	public static boolean validatePassword(String password) throws ValidationException {
			String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			
			if( Pattern.matches(patternString, password)) {
				  return true;
			  }else {
				  throw new ValidationException("Password must contain one uppercase , one lowercase , one special character , length of eight character");
			  }
	}

	public static  boolean validateEmail(String email) throws ValidationException{
			String regex = "^.*@.*\\..*$";	
			if( Pattern.matches(regex, email)) {
				  return true;
			  }else {
				  throw new ValidationException("Please enter appropriate email");
			  }
	}
	
	public   void validateEmailId(String email) throws InvalidUserException{
		String regex = "^.*@.*\\..*$";
		if (!Pattern.matches(regex, email))
			throw new InvalidUserException("Email id is not valid");
				
}

}

package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.validationexceptions.ValidationException;

public class BookingValidator {
	
	
	
public static boolean validateBooking(Booking booking) throws ValidationException {
		
		if( booking!=null&&validateName(booking.getUserName())&&validateEmail(booking.getEmail())&& validateDestination(booking.getDestination())&&validateSeatNum(booking.getSeatNum())) {
			
			return true;
		} else {
			throw new ValidationException("Booking details are invalid");
		}
		
	}


	public static  boolean validateName(String name) throws ValidationException{
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			if( m.matches()) {
				  return true;
			  }else {
				  throw new ValidationException("Name cannot contain other than letters");
			  }
		
	}
	
	public static  boolean validateDestination(String destination) throws ValidationException {
		
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(destination);
		  if( m.matches()) {
			  return true;
		  }else {
			  throw new ValidationException("Destination cannot contain other than letters");
		  }
			
		
	}
	
	public static  boolean validateSeatNum(int seatNum) throws ValidationException{
		
		boolean match = false;
		if(seatNum>=1 && seatNum<=7) {
			match = true;
		}
				if( match) {
					  return true;
				  }else {
					  throw new ValidationException("Seat Num should be greater that or equal to 1 and  less than 7");
				  }
				
	}
	
	public static  boolean validateEmail(String email) throws ValidationException{
		
		boolean isMatch = false;
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
				if( isMatch) {
					  return true;
				  }else {
					  throw new ValidationException("Please enter appropriate email");
				  }
			
		
	}
	
public static  boolean validateShuttleId(int id) throws ValidationException{
		
		boolean isMatch = false;
		if(id>=1) {
			isMatch = true;
		}
		if( isMatch) {
			  return true;
		  }else {
			  throw new ValidationException("Please enter appropriate shuttle ID");
		  }
		
	}
}

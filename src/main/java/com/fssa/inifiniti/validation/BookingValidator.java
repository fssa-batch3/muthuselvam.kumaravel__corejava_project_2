package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.validationexceptions.InvalidBookingException;

public class BookingValidator {
	
	
	
public static boolean validateBooking(Booking booking) throws InvalidBookingException {
		
		if( booking!=null&&validateName(booking.getUserName())&&validateEmail(booking.getEmail())&& validateDestination(booking.getDestination())&&validateSeatNum(booking.getSeatNum())) {
			
			return true;
		} else {
			throw new InvalidBookingException("Booking details are invalid");
		}
		
	}


	public static  boolean validateName(String name){
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			return m.matches();
			
		
	}
	
	public static  boolean validateDestination(String destination) {
		
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(destination);
		 return m.matches();
			
		
	}
	
	public static  boolean validateSeatNum(int seatNum){
		
		boolean match = false;
		if(seatNum>=1 && seatNum<=7) {
			match = true;
		}
				return match;
				
	}
	
	public static  boolean validateEmail(String email){
		
		boolean isMatch = false;
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
				return isMatch;
			
		
	}
	
public static  boolean validateShuttleId(int id){
		
		boolean isMatch = false;
		if(id>=1) {
			isMatch = true;
		}
		return isMatch;
		
	}
}

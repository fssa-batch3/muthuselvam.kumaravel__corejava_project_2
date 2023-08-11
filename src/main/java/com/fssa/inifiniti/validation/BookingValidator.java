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


	public static  boolean validateName(String name) throws InvalidBookingException {
		boolean match = false;
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				return match;
			} else {
				throw new InvalidBookingException("Invalid Name");
			}
		
	}
	
	public static  boolean validateDestination(String destination) throws InvalidBookingException {
		boolean match = false;
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(destination);
			match = m.matches();
			if (match) {
				return match;
			} else {
				throw new InvalidBookingException("Invalid destination");
			}
		
	}
	
	public static  boolean validateSeatNum(int seatNum) throws InvalidBookingException {
		boolean match = false;
		if(seatNum>=1 && seatNum<=7) {
			match = true;
		}
			if (match) {
				return match;
			} else {
				throw new InvalidBookingException("Invalid Seat Number");
			}
		
	}
	
	public static  boolean validateEmail(String email) throws InvalidBookingException {
		boolean isMatch = false;
		
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				return isMatch;
			} else {
				throw new InvalidBookingException("Invalid Email");
			}
			
		
	}
}

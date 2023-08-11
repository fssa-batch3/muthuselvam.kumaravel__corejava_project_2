package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.validationexceptions.InvalidBookingException;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

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
				System.out.println("The user name is valid.");
			} else {
				throw new InvalidBookingException("Invalid Name");
			}
		return match;
	}
	
	public static  boolean validateDestination(String destination) throws InvalidBookingException {
		boolean match = false;
		
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(destination);
			match = m.matches();
			if (match) {
				System.out.println("destination is valid.");
			} else {
				throw new InvalidBookingException("Invalid destination");
			}
		return match;
	}
	
	public static  boolean validateSeatNum(int seatNum) throws InvalidBookingException {
		boolean match = false;
		if(seatNum>=1 && seatNum<=7) {
			match = true;
		}
			if (match) {
				System.out.println("seatNum is valid.");
			} else {
				throw new InvalidBookingException("Invalid Seat Number");
			}
		return match;
	}
	
	public static  boolean validateEmail(String email) throws InvalidBookingException {
		boolean isMatch = false;
		
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is: Valid");
			} else {
				throw new InvalidBookingException("Invalid Email");
			}
			return isMatch;
		
	}
}

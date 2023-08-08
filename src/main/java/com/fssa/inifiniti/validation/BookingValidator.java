package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.validationexceptions.InvalidBookingException;

public class BookingValidator {
	
	
	
public static boolean ValidateBooking(Booking booking) throws InvalidBookingException {
		
		if( booking!=null&&validateName(booking.getUserName())&&validateDestination(booking.getDestination())&&validateSeatNum(booking.getSeatNum())) {
			
			return true;
		} else {
			throw new InvalidBookingException("Booking details are invalid");
		}
		
	}

	public static  boolean validateName(String name) {
		boolean match = false;
		
			String regex = "^[A-Za-z]\\w{2,29}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				System.out.println("The user name is valid.");
			} else {
				System.out.println("The user name is not valid");
			}
		return match;
	}
	
	public static  boolean validateDestination(String destination) {
		boolean match = false;
		
			String regex = "^[A-Za-z]\\w{2,29}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(destination);
			match = m.matches();
			if (match) {
				System.out.println("destination is valid.");
			} else {
				System.out.println("destination is not valid");
			}
		return match;
	}
	
	public static  boolean validateSeatNum(int seatNum) {
		boolean match = false;
		if(seatNum>=1 && seatNum<=7) {
			match = true;
		}
			if (match) {
				System.out.println("seatNum is valid.");
			} else {
				System.out.println("seatNum is not valid");
			}
		return match;
	}
}

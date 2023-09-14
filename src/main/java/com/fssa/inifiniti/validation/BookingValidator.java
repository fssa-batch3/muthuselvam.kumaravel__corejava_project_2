package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.validationexceptions.ValidationException;

/**
 * The BookingValidator class provides methods for validating booking-related information.
 * It includes methods for validating user names, email addresses, destinations, seat numbers, and shuttle IDs.
 */

public class BookingValidator {
	
	 
	/**
	 * Validates the attributes of a Booking object.
	 *
	 * @param booking The Booking object to validate.
	 * @return true if all attributes of the Booking object are valid, otherwise false.
	 * @throws ValidationException If any attribute of the Booking object is invalid.
	 */ 
	
public static boolean validateBooking(Booking booking) throws ValidationException {
		
	validateBookingNotNull(booking);
	validateName(booking.getUserName()); 
	validateEmail(booking.getEmail());
	validateDestination(booking.getDestination());
	validateSeatNum(booking.getSeatNum());
	
	return true;
	}


/**
 * Validates if a Booking object is not null.
 *
 * @param booking The Booking object to validate.
 * @return true if the Booking object is not null, otherwise false.
 * @throws ValidationException If the Booking object is null.
 */


public static boolean validateBookingNotNull(Booking booking)throws ValidationException{
	if(booking == null) {
		throw new ValidationException("Booking is null");
	}
	return true;
}

/**
 * Validates a user name, ensuring it contains only letters.
 *
 * @param name The user name to be validated.
 * @return True if the user name is valid; otherwise, false.
 * @throws ValidationException If the user name is invalid.
 */

	public static  boolean validateName(String name) throws ValidationException{
		if(name != null) {
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			if( m.matches()) {
				  return true;
			  }else {
				  throw new ValidationException("Username cannot contain other than letters");
			  }} else {
				  throw new ValidationException("Username cannot be null");
			  }
		
	}
	
	/**
     * Validates a destination, ensuring it contains only letters.
     *
     * @param destination The destination to be validated.
     * @return True if the destination is valid; otherwise, false.
     * @throws ValidationException If the destination is invalid.
     */
	
	public static  boolean validateDestination(String destination) throws ValidationException {
		
		if(destination != null) {
			String regex = "^[A-Za-z]+$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(destination);
		  if( m.matches()) {
			  return true;
		  }else {
			  throw new ValidationException("Destination cannot contain other than letters");
		  }
		} else {
			  throw new ValidationException("destination cannot be null");
		  }
	
		
	}
	
	 /**
     * Validates a seat number, ensuring it is within the valid range (1 to 7).
     *
     * @param seatNum The seat number to be validated.
     * @return True if the seat number is valid; otherwise, false.
     * @throws ValidationException If the seat number is invalid.
     */
	
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
	 
	 /**
     * Validates an email address using a regular expression pattern.
     *
     * @param email The email address to be validated.
     * @return True if the email address is valid; otherwise, false.
     * @throws ValidationException If the email address is invalid.
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
     * Validates a shuttle ID, ensuring it is greater than or equal to 1.
     *
     * @param id The shuttle ID to be validated.
     * @return True if the shuttle ID is valid; otherwise, false.
     * @throws ValidationException If the shuttle ID is invalid.
     */
	
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

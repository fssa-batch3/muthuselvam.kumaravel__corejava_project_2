package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.Shuttle;
import com.fssa.inifiniti.validationexceptions.InvalidShuttleException;

/**
 * The ShuttleValidator class provides methods for validating shuttle-related information.
 * It includes methods for validating shuttle dates and times.
 */

public class ShuttleValidator {

	/**
     * Validates a shuttle, checking that the date and time are valid.
     *
     * @param shuttle The shuttle to be validated.
     * @return True if the shuttle is valid; otherwise, false.
     * @throws InvalidShuttleException If the shuttle details are invalid.
     */
	
	public static boolean validateShuttle(Shuttle shuttle) throws InvalidShuttleException {

		if (shuttle != null && validateDate(shuttle.getDate()) &&  validateTime(shuttle.getTime())) {

			return true;
		} else {
			throw new InvalidShuttleException("Shuttle details are invalid");
		}

	}

	 /**
     * Validates a date string, ensuring it follows the specified date format.
     *
     * @param date The date string to be validated.
     * @return True if the date string is valid; otherwise, false.
     */
	
	public static boolean validateDate(String d) {
		String regex = "^(3[01]|[12]\\d|0[1-9])/(1[0-2]|0[1-9])/\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(d);
		return matcher.matches();
	} 

	/**
     * Validates a time string, ensuring it follows the specified time format.
     *
     * @param time The time string to be validated.
     * @return True if the time string is valid; otherwise, false.
     */
	
	public static boolean validateTime(String time) {
		String regex = "([01]?\\d|2[0-3]):[0-5]\\d";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(time);
		return m.matches();
	}

}

package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.Shuttle;
import com.fssa.inifiniti.validationexceptions.InvalidShuttleException;

public class ShuttleValidator {

	public static boolean validateShuttle(Shuttle shuttle) throws InvalidShuttleException {

		if (shuttle != null && validateDate(shuttle.getDate()) &&  validateTime(shuttle.getTime())) {

			return true;
		} else {
			throw new InvalidShuttleException("Shuttle details are invalid");
		}

	}

	public static boolean validateDate(String d) {
		String regex = "^(3[01]|[12]\\d|0[1-9])/(1[0-2]|0[1-9])/\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher((CharSequence) d);
		return matcher.matches();
	}

	public static boolean validateTime(String time) {
		String regex = "([01]?\\d|2[0-3]):[0-5]\\d";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(time);
		return m.matches();
	}

}

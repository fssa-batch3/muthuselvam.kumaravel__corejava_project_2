package com.fssa.inifiniti.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.Shuttle;
import com.fssa.inifiniti.validationexceptions.InvalidShuttleException;

public class ShuttleValidator {

	public static boolean validateShuttle(Shuttle shuttle) throws InvalidShuttleException {

		if (shuttle != null && ValidateDate(shuttle.getDate()) &&  ValidateTime(shuttle.getTime())) {

			return true;
		} else {
			throw new InvalidShuttleException("Shuttle details are invalid");
		}

	}

	public static boolean ValidateDate(String d) {
		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher((CharSequence) d);
		return matcher.matches();
	}

	public static boolean ValidateTime(String time) {
		String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(time);
		return m.matches();
	}

}

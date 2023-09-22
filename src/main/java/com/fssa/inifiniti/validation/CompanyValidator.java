package com.fssa.inifiniti.validation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.validationexceptions.InvalidCompanyException;

/**
 * The CompanyValidator class provides methods for validating company-related
 * information. It includes methods for validating company names and image URLs.
 */

public class CompanyValidator {

	/**
	 * Validates a company, checking that the company name and image URL are valid.
	 *
	 * @param company The company to be validated.
	 * @return True if the company is valid; otherwise, false.
	 * @throws InvalidCompanyException If the company details are invalid.
	 */

	public static boolean validateCompany(CompanyCard company) throws InvalidCompanyException {

		if (company != null && validateName(company.getCompanyTitle()) && validateUrl(company.getImageUrl())) {

			return true;
		} else {
			throw new InvalidCompanyException("Company details are invalid");
		}

	}

	/**
	 * Validates a company name, ensuring it follows the specified pattern.
	 *
	 * @param name The company name to be validated.
	 * @return True if the company name is valid; otherwise, false.
	 * @throws InvalidCompanyException 
	 */

	public static boolean validateName(String name) throws InvalidCompanyException {
		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		if ( m.matches()) {
			return true;
		}else {
			throw new InvalidCompanyException("Company name is invalid");
		}

	}

	 /**
     * Validates an image URL, checking if it can be converted to a valid URL.
     *
     * @param url The image URL to be validated.
     * @return True if the URL is valid; otherwise, false.
	 * @throws InvalidCompanyException 
     */
	public static boolean validateUrl(String url) throws InvalidCompanyException {
		boolean match = false;
		try {
			new URL(url).toURI();
			match = true;
			return match;
		} catch (MalformedURLException | URISyntaxException e) {
			throw new InvalidCompanyException("Company logo url is invalid");
		}
	}

}

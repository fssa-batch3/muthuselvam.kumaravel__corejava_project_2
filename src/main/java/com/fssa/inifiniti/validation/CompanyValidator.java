package com.fssa.inifiniti.validation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.validationexceptions.InvalidCompanyException;

public class CompanyValidator {
	
	
public static boolean validateCompany(CompanyCard company) throws InvalidCompanyException {
		
		if(company!=null&&validateName(company.getCompanyTitle()) && validateUrl(company.getImageUrl())  ) {
			
			return true;
		} else {
			throw new InvalidCompanyException("Company details are invalid");
		}
		
	}

	public static  boolean validateName(String name) {
		boolean match = false;
			String regex = "^[A-Za-z]\\w{2,29}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				System.out.println("The Company Title is valid.");
			} else {
				System.out.println("The Company Title is not valid");
			}
		return match;
	}
	
	public static  boolean validateUrl(String url)  {
		boolean match = false;
		try {
            new URL(url).toURI();
            return match = true;
        }
        catch (MalformedURLException|URISyntaxException e) {
            return match;
        }
	}

}

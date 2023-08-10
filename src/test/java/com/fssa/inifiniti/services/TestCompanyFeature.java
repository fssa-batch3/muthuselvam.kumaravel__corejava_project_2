package com.fssa.inifiniti.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import com.fssa.inifiniti.model.*;
import com.fssa.inifiniti.services.*;
import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.services.exceptions.ServiceException;

public class TestCompanyFeature {
	 @Test
		
	 void testBookingRegisterSuccess() {
	CompanyCard company = new CompanyCard("Zoho","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDyxA_bZSxuIGq-qyfXVRLbbhUnDRa5wxXVA&usqp=CAU");
	CompanyCardService companyService = new CompanyCardService();
			try {
				assertTrue(companyService.registerCompany(company));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

}

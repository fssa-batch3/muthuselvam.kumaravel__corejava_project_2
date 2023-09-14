package com.fssa.inifiniti.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import java.util.*;
 class TestCompanyFeature {
	 @Test
		
	 void testCompanyCardSucess() {
	CompanyCard company = new CompanyCard("Air BNB","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDyxA_bZSxuIGq-qyfXVRLbbhUnDRa5wxXVA&usqp=CAU");
	CompanyCardService companyService = new CompanyCardService();
			try {
				assertFalse(companyService.registerCompany(company));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
	}
	 
	 @Test
		
	 void testCompanyRead() {
	
	CompanyCardService companyService = new CompanyCardService(); 
			try {
				List<CompanyCard> result = companyService.readCompany();
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			} 
		
		
	}
	 
	 @Test
		
	 void testEditCompanyCard() {
	CompanyCard company = new CompanyCard("Sales Force","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMuEuuj2JGGWKyQqpNAmzLWXQAsdG07jBPZQ&usqp=CAU",2);
	CompanyCardService companyService = new CompanyCardService();
			try {
				assertFalse(companyService.updateCompany(company));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		 
		
	}
	 
	 @Test
		
	 void testDeleteCompanyCard() {
	CompanyCard company = new CompanyCard(2);
	CompanyCardService companyService = new CompanyCardService();
			try {
				assertFalse(companyService.deleteCompany(company));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
				fail();
			}
		
		
	}

	 
	
}

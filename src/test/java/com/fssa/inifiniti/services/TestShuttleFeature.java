package com.fssa.inifiniti.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.model.Shuttle;
import com.fssa.inifiniti.services.exceptions.ServiceException;

class TestShuttleFeature {
	 
	 @Test
		
	 void testShuttleRegisterSuccess() {
	Shuttle shuttle = new Shuttle(16,"FRESHWORKS", "08/09/2023" , "18:00");
	ShuttleService shuttleService = new ShuttleService();
			try {
				assertTrue(shuttleService.registerShuttle(shuttle));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	} 
	 
	 @Test
		 
	 void testNullInput() {
	Shuttle shuttle =  null;
	ShuttleService shuttleService = new ShuttleService();
			try {
				assertFalse(shuttleService.registerShuttle(shuttle));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	 
	 @Test
		
	 void testReadShuttleTimeAndDate() {
		 Shuttle shuttle = new Shuttle(2,"FRESHWORKS", "29/08/2023" , "20:00");
		 ShuttleService shuttleService = new ShuttleService();
			try {
				List<Shuttle> result = shuttleService.readShuttleTimeAndDate(shuttle.getCompanyName());
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}
	 
	 @Test
		
	 void testReadIdByShuttleTimeAndDateAndCompanyName() {
		 Shuttle shuttle = new Shuttle(2,"FRESHWORKS", "29/08/2023" , "20:00");
		 ShuttleService shuttleService = new ShuttleService();
			try {
				Shuttle result = shuttleService.readIdByShuttleTimeAndDateAndCompanyName(shuttle.getDate(),shuttle.getTime(),shuttle.getCompanyName());
				System.out.println(result.getShuttleId());
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

	 
	 

}

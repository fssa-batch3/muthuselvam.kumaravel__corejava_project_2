package com.fssa.inifiniti.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.model.Shuttle;
import com.fssa.inifiniti.services.exceptions.ServiceException;

class TestShuttleFeature {
	 
	 @Test
		
	 void testShuttleRegisterSuccess() {
	Shuttle shuttle = new Shuttle(2,"FRESHWORKS", "29/08/2023" , "20:00");
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
	 
	 

}

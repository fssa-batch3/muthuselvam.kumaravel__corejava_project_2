package com.fssa.inifiniti.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.services.exceptions.ServiceException;
 class TestBookingFeature {

	 @Test
	
	 void testBookingRegisterSuccess() {
	Booking booking = new Booking(1,"muthu","sriyaasha@gmail.com", "Taramani",1);
			try {
				assertTrue(BookingService.registerBooking(booking));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}


	@Test
	
	 void testSeatNumAlreadyExists() {
	Booking booking = new Booking(1,"muthu","sriyaasha@gmail.com", "Taramani",1);
	        try {
				assertFalse(BookingService.registerBooking(booking));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

	
	@Test

	 void testEditSeatNum() {
	        try {
				assertTrue(BookingService.updateBooking(1,"sriyaasha@gmail.com",1,6));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}
	
	@Test

	 void testDeleteBooking() {
		Booking booking = new Booking(1,"sriyaasha@gmail.com");
	        try {
				assertTrue(BookingService.deleteBooking(booking));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

	
	@Test
	
		 void testReadBookings() {
			Booking booking = new Booking("sriyaasha@gmail.com");
		        try {
					assertTrue(BookingService.readBookingByUser(booking));
				}  	
				 catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					fail();
					
				}
			
			
		}
	
	
	@Test

	 void testViewBookingsByAdmin() {
	        try {
				assertTrue(BookingService.readBookingByAdmin());
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

  }

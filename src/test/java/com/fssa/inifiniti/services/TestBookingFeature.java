package com.fssa.inifiniti.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.services.exceptions.ServiceException;
 class TestBookingFeature {

	 @Test
	
	 void testBookingRegisterSuccess() {
	Booking booking = new Booking(1,"muthu","sriyaasha@gmail.com", "Taramani",4);
			try {
				assertTrue(BookingService.registerBooking(booking));
			}  	
			 catch (ServiceException e) {
				e.printStackTrace();
				fail();
			}
		
		
	}


	@Test
	
	 void testSeatNumAlreadyExists() {
	Booking booking = new Booking(1,"muthu","sriyaasha@gmail.com", "Taramani",4);
	        try {
				assertFalse(BookingService.registerBooking(booking));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	
	@Test
	
	 void testEditSeatNum() {
	        try {
				assertTrue(BookingService.updateBooking(1,"sriyaasha@gmail.com",4,6));
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
			Booking booking = new Booking("selvam143@gmail.com");
			BookingService bookingService = new BookingService();
		        try {
		        	List<Booking> bookingList = bookingService.readBookingByUser(booking);
		        	for (Booking  i : bookingList) {
		        		System.out.println(i.toString());
		        	}
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
	        	BookingService bookingService = new BookingService();
				bookingService.readBookingByAdmin();
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

  }

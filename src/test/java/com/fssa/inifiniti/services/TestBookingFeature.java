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
	@Order(1)
	 void testBookingRegisterSuccess() {
	Booking booking = new Booking(2,"muthu","sriyaasha@gmail.com", "Taramani",5);
			try {
				assertTrue(BookingService.registerBooking(booking));
			}  	
			 catch (ServiceException e) {
				 e.printStackTrace();
			}
		 
		  
	}


	@Test
	@Order(2)
	 void testSeatNumAlreadyExists() {
	Booking booking = new Booking(2,"muthu","sriyaasha@gmail.com", "Taramani",5);
	        try {
				assertFalse(BookingService.registerBooking(booking));
			}  	
			 catch (ServiceException e) {
				e.printStackTrace();
			} 
		 
		 
	}
 
	
	@Test
	@Order(3)
	 void testEditSeatNum() {
	        try {
				assertTrue(BookingService.updateBooking(2,"sriyaasha@gmail.com",5,6));
			}  	
			 catch (ServiceException e) {
			
				fail();
			}
		
		
	}
	
	@Test
	@Order(4)
	 void testDeleteBooking() {
		Booking booking = new Booking(2,"sriyaasha@gmail.com");
	        try {
				assertFalse(BookingService.deleteBooking(booking));
			}  	
			 catch (ServiceException e) {
				
				fail();
			}
		
		
	}  

	
	@Test
	@Order(5)
		 void testReadBookings() {
			Booking booking = new Booking("veeramuthu@gmail.com");
			BookingService bookingService = new BookingService();
		        try {
		        	List<Booking> bookingList = bookingService.readBookingByUser(booking);
				}  	
				 catch (ServiceException e) {
					fail();
				}
			 
			
		}
	
	
	@Test
	@Order(6)
	 void testViewBookingsByAdmin() {
	        try {
	        	BookingService bookingService = new BookingService();
				bookingService.readBookingByAdmin();
			}  	
			 catch (ServiceException e) {
				fail();
			}
		
		
	}
	@Test
	@Order(7)
		 void testReadBookingsbyUser() {
			Booking booking = new Booking("veeramuthu@gmail.com");
			BookingService bookingService = new BookingService();
		        try {
		        	List<Booking> bookingList = bookingService.readBookingByUser(booking);
				}  	
				 catch (ServiceException e) {
					fail();
				}
			 
			
		}
	
  }

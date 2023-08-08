package com.fssa.inifiniti.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.services.BookingService;
import com.fssa.inifiniti.services.exceptions.ServiceException;
public class TestBookingFeature {

//@Test
//	
//	public void testBookingRegisterSuccess() {
//	Booking booking = new Booking(1,"muthu","sriyaasha@gmail.com", "Taramani",1);
//			try {
//				assertTrue(BookingService.registerBooking(booking));
//			}  	
//			 catch (ServiceException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				fail();
//			}
//		
//		
//	}


//@Test
//
//public void testSeatNumAlreadyExists() {
//Booking booking = new Booking(1,"muthu","sriyaasha@gmail.com", "Taramani",1);
//        try {
//			assertFalse(BookingService.registerBooking(booking));
//		}  	
//		 catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			fail();
//		}
//	
//	
//}

	
//	@Test
//
//	public void testEditSeatNum() {
//	        try {
//				assertTrue(BookingService.editBooking(1,"sriyaasha@gmail.com",1,6));
//			}  	
//			 catch (ServiceException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				fail();
//			}
//		
//		
//	}
	
//	@Test
//
//	public void testDeleteBooking() {
//		Booking booking = new Booking(1,"sriyaasha@gmail.com");
//	        try {
//				assertTrue(BookingService.deleteBooking(booking));
//			}  	
//			 catch (ServiceException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				fail();
//			}
//		
//		
//	}

	
	@Test
	
		public void test() {
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

  }

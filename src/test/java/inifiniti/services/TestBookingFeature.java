package inifiniti.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import inifiniti.model.*;
import org.junit.jupiter.api.Test;

import inifiniti.services.exceptions.ServiceException;
import inifiniti.dao.*;
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
					System.out.print(BookingService.readBookingByUser(booking));
				}  	
				 catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					fail();
				}
			
			
		}

  }
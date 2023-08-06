package inifiniti.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import inifiniti.model.*;
import org.junit.jupiter.api.Test;

import inifiniti.services.exceptions.ServiceException;

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

	
	@Test

	public void testEditSeatNum() {
	        try {
				assertTrue(BookingService.editBooking(1,"sriyaasha@gmail.com",1,6));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

  }

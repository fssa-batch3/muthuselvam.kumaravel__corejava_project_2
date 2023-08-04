package inifiniti.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import inifiniti.model.*;
import org.junit.jupiter.api.Test;

import inifiniti.services.exceptions.ServiceException;

public class TestBookingFeature {

@Test
	
	public void testBookingRegisterSuccess() {
	Booking booking = new Booking(1,"muthu", "Taramani",1);
			try {
				assertTrue(BookingService.registerBooking(booking));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}

}

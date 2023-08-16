package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidBookingException;



 class TestValidateDestination {
	 Throwable exception;
	
	@Test
	
	 void testValidDestination() throws InvalidBookingException {
		
		try {
			assertTrue(BookingValidator.validateDestination("taramani"));
		} catch (InvalidBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	
	}
	
	@Test
	 
	 void testInvalidDestination() throws  InvalidBookingException {
		
		try {
			assertFalse(BookingValidator.validateDestination("taramani2"));
			 exception = assertThrows(InvalidBookingException.class, () -> {
				});
				assertEquals("Invalid destination", exception.getMessage());
		} catch (InvalidBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidBookingException;



 class TestValidateDestination {
	 Throwable exception;
	
	@Test
	
	 void testValidDestination() {
			assertTrue(BookingValidator.validateDestination("taramani"));
	}
	
	@Test
	 
	 void testInvalidDestination() {
		
		
			assertFalse(BookingValidator.validateDestination("taramani2"));
			 exception = assertThrows(InvalidBookingException.class, () -> {
				});
				assertEquals("Invalid destination", exception.getMessage());
	
	}

}

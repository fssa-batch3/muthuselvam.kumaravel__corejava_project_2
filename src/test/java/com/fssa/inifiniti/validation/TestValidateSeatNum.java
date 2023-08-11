package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidBookingException;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

 class TestValidateSeatNum {
	Throwable exception;
	@Test
	
	 void testValidSeatnum() throws InvalidBookingException {
		
		try {
			assertTrue(BookingValidator.validateSeatNum(1));
		} catch (InvalidBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	
	}
	
	@Test
	
	 void testInvalidSeatNum() throws  InvalidBookingException {
		
		try {
			BookingValidator.validateSeatNum(8);
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Seat Number", exception.getMessage());
		} catch (InvalidBookingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

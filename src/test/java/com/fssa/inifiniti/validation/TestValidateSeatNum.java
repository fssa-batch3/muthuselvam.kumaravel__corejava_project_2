package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidBookingException;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

 class TestValidateSeatNum {
	Throwable exception;
	@Test
	
	 void testValidSeatnum(){
		
		
			assertTrue(BookingValidator.validateSeatNum(1));
	
	}
	
	@Test
	
	 void testInvalidSeatNum()  {
		
		
			BookingValidator.validateSeatNum(8);
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Seat Number", exception.getMessage());
		
	}

}

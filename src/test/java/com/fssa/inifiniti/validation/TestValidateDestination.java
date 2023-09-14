package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.ValidationException;



 class TestValidateDestination {
	 Throwable exception;
	
	@Test
	
	 void testValidDestination() {
			try {
				assertTrue(BookingValidator.validateDestination("taramani"));
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
	}
	
	
	 
	@Test
	 
	 void testInvalidDestination() {
				exception = assertThrows(ValidationException.class, () -> BookingValidator.validateDestination("taramani2"));
				assertEquals("Destination cannot contain other than letters", exception.getMessage());
	}
	
	@Test
	 
	 void testInvalidDestinationWithNumber() {
				exception = assertThrows(ValidationException.class, () -> BookingValidator.validateDestination("12345"));
				assertEquals("Destination cannot contain other than letters", exception.getMessage());
	}
	
	@Test
	 
	 void testInvalidDestinationWithSpecialChar() {
				exception = assertThrows(ValidationException.class, () -> BookingValidator.validateDestination("!@#$%"));
				assertEquals("Destination cannot contain other than letters", exception.getMessage());
	}
	
	@Test
	 
	 void testInvalidDestinationWithNull() {
				exception = assertThrows(ValidationException.class, () -> BookingValidator.validateDestination(null));
				assertEquals("destination cannot be null", exception.getMessage());
	}
	

}

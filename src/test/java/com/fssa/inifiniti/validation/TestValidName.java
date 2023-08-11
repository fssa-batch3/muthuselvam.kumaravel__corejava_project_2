package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidUserException;

 class TestValidName {
	
	Throwable exception;
	@Test
	
	 void testValidName() throws InvalidUserException {
		
		try {
			assertTrue(UserValidator.validateName("muthu"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	
	}
	
	@Test
	
	 void testInvalidName() throws InvalidUserException {
		
		try {
			UserValidator.validateName("muthu@");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Username", exception.getMessage());
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

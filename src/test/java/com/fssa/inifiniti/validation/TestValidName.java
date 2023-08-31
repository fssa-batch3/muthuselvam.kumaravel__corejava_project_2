package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidUserException;

 class TestValidName {
	
	Throwable exception;
	@Test
	
	 void testValidName()  {
		
		assertTrue(UserValidator.validateName("muthu"));
	
	}
	
	@Test
	
	 void testInvalidName() {
		
		UserValidator.validateName("muthu@");
		 exception = assertThrows(InvalidUserException.class, () -> {
			});
			assertEquals("Invalid Username", exception.getMessage());
	
	}
}

package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.ValidationException;

 class TestValidName {
	
	Throwable exception;
	@Test
	
	 void testValidName()  {
		
		try {
			assertTrue(UserValidator.validateName("muthu"));
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test
	
	 void testInvalidName() {
		
		
		 exception = assertThrows(ValidationException.class, () -> UserValidator.validateName("muthu@"));
			assertEquals("Name cannot contain other than letters", exception.getMessage());
	
	}
}

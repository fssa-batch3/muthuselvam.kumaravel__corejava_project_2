package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidUserException;

 class TestValidEmail {
	Throwable exception;

	@Test
		
		void testValidEmail()  {
			
			
				assertTrue(UserValidator.validateEmail("muthu@gmail.com"));
			
		}

	@Test
	
	void testInvalidEmailWithoutAt() {
		
		
			UserValidator.validateEmail("muthugmail.com");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Email", exception.getMessage());
		
	}
	
@Test
	
	void testInvalidEmailWithouDotCom()  {
		
	
			UserValidator.validateEmail("muthu@gmail");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Email", exception.getMessage());
		
	}
	

}

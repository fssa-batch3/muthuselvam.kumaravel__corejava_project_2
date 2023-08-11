package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validation.UserValidator;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class TestValidEmail {
	Throwable exception;

	@Test
		
		void testValidEmail() throws InvalidUserException {
			
			try {
				assertTrue(UserValidator.validateEmail("muthu@gmail.com"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	@Test
	
	void testInvalidEmailWithoutAt() throws InvalidUserException {
		
		try {
			UserValidator.validateEmail("muthugmail.com");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Email", exception.getMessage());
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
@Test
	
	void testInvalidEmailWithouDotCom() throws InvalidUserException {
		
		try {
			UserValidator.validateEmail("muthu@gmail");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Email", exception.getMessage());
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

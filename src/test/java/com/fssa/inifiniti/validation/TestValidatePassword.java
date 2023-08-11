package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidUserException;

class TestValidatePassword {
Throwable exception;
	@Test
	
	void testValidPassword() throws InvalidUserException {
		
		try {
			assertTrue(UserValidator.validatePassword("Muthu@143"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 

	@Test
	
	 void testInvalidPasswordWithoutSpecChar() throws InvalidUserException {
		
		try {
			UserValidator.validatePassword("Muthu143");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Password", exception.getMessage());
		} catch ( InvalidUserException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	
	 void testInvalidPasswordWithoutNum() throws InvalidUserException {
		
		try {
			UserValidator.validatePassword("Muthu@");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Password", exception.getMessage());
		} catch (InvalidUserException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	
	 void testInvalidPasswordWithoutCap() throws InvalidUserException{
		
		try {
			UserValidator.validatePassword("muthu@143");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Password", exception.getMessage());
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test

	 void testInvalidPasswordWithoutsmall() throws InvalidUserException{
	
	try {
	UserValidator.validatePassword("MUTHU@143");
		 exception = assertThrows(InvalidUserException.class, () -> {
			});
			assertEquals("Invalid Password", exception.getMessage());
	} catch (InvalidUserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.InvalidUserException;

class TestValidatePassword {
Throwable exception;
	@Test
	
	void testValidPassword(){
		
		
			assertTrue(UserValidator.validatePassword("Muthu@143"));
	
	}
	 

	@Test
	
	 void testInvalidPasswordWithoutSpecChar(){
		
		
			UserValidator.validatePassword("Muthu143");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Password", exception.getMessage());
	}
	
	@Test
	
	 void testInvalidPasswordWithoutNum()  {
		
		
			UserValidator.validatePassword("Muthu@");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Password", exception.getMessage());
	}
	
	@Test
	
	 void testInvalidPasswordWithoutCap() {
		
		
			UserValidator.validatePassword("muthu@143");
			 exception = assertThrows(InvalidUserException.class, () -> {
				});
				assertEquals("Invalid Password", exception.getMessage());
		
	}

	@Test

	 void testInvalidPasswordWithoutsmall() {
	
	
	UserValidator.validatePassword("MUTHU@143");
		 exception = assertThrows(InvalidUserException.class, () -> {
			});
			assertEquals("Invalid Password", exception.getMessage());
	
}
}

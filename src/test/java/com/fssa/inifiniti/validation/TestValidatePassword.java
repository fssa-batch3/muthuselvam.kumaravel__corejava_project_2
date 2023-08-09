package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validation.UserValidator;

class TestValidatePassword {

	@Test
	
	void testValidPassword() {
		
		assertTrue(UserValidator.validatePassword("Muthu@143"));
	}
	

	@Test
	
	 void testInvalidPasswordWithoutSpecChar() {
		
		assertFalse(UserValidator.validatePassword("Muthu143"));
	}
	
	@Test
	
	 void testInvalidPasswordWithoutNum() {
		
		assertFalse(UserValidator.validatePassword("Muthu@"));
	}
	
	@Test
	
	 void testInvalidPasswordWithoutCap() {
		
		assertFalse(UserValidator.validatePassword("muthu@143"));
	}

	@Test

	 void testInvalidPasswordWithoutsmall() {
	
	assertFalse(UserValidator.validatePassword("MUTHU@143"));
}
}

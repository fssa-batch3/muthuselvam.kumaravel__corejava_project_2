package inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import inifiniti.validation.UserValidator;

public class TestValidatePassword {

	@Test
	
	public void testValidPassword() {
		
		assertTrue(UserValidator.validatePassword("Muthu@143"));
	}
	

	@Test
	
	public void testInvalidPasswordWithoutSpecChar() {
		
		assertFalse(UserValidator.validatePassword("Muthu143"));
	}
	
	@Test
	
	public void testInvalidPasswordWithoutNum() {
		
		assertFalse(UserValidator.validatePassword("Muthu@"));
	}
	
	@Test
	
	public void testInvalidPasswordWithoutCap() {
		
		assertFalse(UserValidator.validatePassword("muthu@143"));
	}

	@Test

	public void testInvalidPasswordWithoutsmall() {
	
	assertFalse(UserValidator.validatePassword("MUTHU@143"));
}
}

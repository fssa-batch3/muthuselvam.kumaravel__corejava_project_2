package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.ValidationException;

class TestValidatePassword {
Throwable exception;
	@Test
	
	void testValidPassword(){
		
		
			try {
				assertTrue(UserValidator.validatePassword("Muthu@143"));
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	 

	@Test
	
	 void testInvalidPasswordWithoutSpecChar(){
		
		
			
			 exception = assertThrows(ValidationException.class, () -> UserValidator.validatePassword("Muthu143"));
				assertEquals("Password must contain one uppercase , one lowercase , one special character , length of eight character", exception.getMessage());
	}
	
	@Test
	
	 void testInvalidPasswordWithoutNum()  {
		
		
			
			 exception = assertThrows(ValidationException.class, () -> UserValidator.validatePassword("Muthu@"));
				assertEquals("Password must contain one uppercase , one lowercase , one special character , length of eight character", exception.getMessage());
	}
	
	@Test
	
	 void testInvalidPasswordWithoutCap() {
		
		
			
			 exception = assertThrows(ValidationException.class, () -> UserValidator.validatePassword("muthu@143"));
				assertEquals("Password must contain one uppercase , one lowercase , one special character , length of eight character", exception.getMessage());
		
	}

	@Test

	 void testInvalidPasswordWithoutsmall() {
	
	
	
		 exception = assertThrows(ValidationException.class, () -> UserValidator.validatePassword("MUTHU@143"));
			assertEquals("Password must contain one uppercase , one lowercase , one special character , length of eight character", exception.getMessage());
	
}
}

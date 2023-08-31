package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.ValidationException;

 class TestValidEmail {
	Throwable exception;

	@Test
		
		void testValidEmail()  {
			
			
				try {
					assertTrue(UserValidator.validateEmail("muthu@gmail.com"));
				} catch (ValidationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

	@Test
	
	void testInvalidEmailWithoutAt() {
		
		
			
			 exception = assertThrows(ValidationException.class, () -> UserValidator.validateEmail("muthugmail.com"));
				assertEquals("Please enter appropriate email", exception.getMessage());
		
	}
	
@Test
	
	void testInvalidEmailWithouDotCom()  {
		
	
			
			 exception = assertThrows(ValidationException.class, () -> UserValidator.validateEmail("muthu@gmail"));
				assertEquals("Please enter appropriate email", exception.getMessage());
		
	}
	

}

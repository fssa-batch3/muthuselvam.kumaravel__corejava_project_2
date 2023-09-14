package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.validationexceptions.ValidationException;

class TestValidEmail {
	Throwable exception;

	@Test

	void testValidEmail() {

		try {
			assertTrue(UserValidator.validateEmail("muthu@gmail.com"));
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test

	void testInvalidEmailWithouDotCom() {

		exception = assertThrows(ValidationException.class, () -> UserValidator.validateEmail("muthu@gmail"));
		assertEquals("Please enter a valid email address", exception.getMessage());

	}

	@Test

	void testInvalidEmailWithoutGmail() {

		exception = assertThrows(ValidationException.class, () -> UserValidator.validateEmail("muthuselvam"));
		assertEquals("Please enter a valid email address", exception.getMessage());

	}
	@Test

	void testInvalidEmailWithoutletters() {

		exception = assertThrows(ValidationException.class, () -> UserValidator.validateEmail("muthuselvam@.com"));
		assertEquals("Please enter a valid email address", exception.getMessage());

	} 
	
	@Test

	void testInvalidEmailForNull() {

		exception = assertThrows(ValidationException.class, () -> UserValidator.validateEmail(null));
		assertEquals("Email cannot be null", exception.getMessage());

	}

}

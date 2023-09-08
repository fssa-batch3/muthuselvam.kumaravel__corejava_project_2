package com.fssa.inifiniti.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.fssa.inifiniti.validationexceptions.ValidationException;

class TestValidatePassword {
Throwable exception;

@ParameterizedTest
@ValueSource(strings = {"Muthu@143", "Muthu143","  ","Muthu@","muthu@143","MUTHU@143","muthu 143"})
void testValidatePassword(String password) {
    try {
        UserValidator.validatePassword(password);
    } catch (ValidationException e) {
    	assertEquals("Password must contain one uppercase , one lowercase , one special character , length of eight character", e.getMessage());
	}
       
    }
}


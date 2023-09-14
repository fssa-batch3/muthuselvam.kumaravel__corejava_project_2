package com.fssa.inifiniti.services;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.inifiniti.services.exceptions.ServiceException;

 class TestLoginFeature {

@Test
	
	 void testloginSuccess() {
			try {
				assertTrue(UserService.loginUser("veeramuthu@gmail.com","Veeramuthu@143"));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		  
	}

@Test 

void testInvalidloginSuccess() {
		try {
			assertFalse(UserService.loginUser("joel@gmail.com","Muthu@456"));
		}  	
		 catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
	
	
}
@Test

 void testInvalidPassword() {
	try {
		assertFalse(UserService.loginUser("sriyaasha@gmail.com","Muthu#458"));
	}  	
	 catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

@Test
 void testNullInput() {
   
    try {
		assertFalse(UserService.loginUser(null,null));
	} catch (ServiceException e) {
		
		e.printStackTrace();
	}
}

@Test

 void testInvalidEmail() {
	try {
		assertFalse(UserService.loginUser("sriyaasha#gmail.com","Muthu@458"));
	}  	
	 catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}
}

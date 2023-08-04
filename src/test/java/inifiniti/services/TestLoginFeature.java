package inifiniti.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import inifiniti.dao.exceptions.DaoException;
import inifiniti.model.User;
import inifiniti.services.exceptions.ServiceException;

public class TestLoginFeature {

@Test
	
	public void testloginSuccess() {
			try {
				assertTrue(UserService.LoginUser("sriyaasha@gmail.com","Muthu@456"));
			}  	
			 catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		
		
	}
@Test

public void testInvalidPassword() {
	try {
		assertFalse(UserService.LoginUser("sriyaasha@gmail.com","Muthu#458"));
	}  	
	 catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

@Test
public void testNullInput() {
   
    try {
		assertFalse(UserService.LoginUser(null,null));
	} catch (ServiceException e) {
		
		e.printStackTrace();
	}
}

@Test

public void testInvalidEmail() {
	try {
		assertFalse(UserService.LoginUser("sriyaasha#gmail.com","Muthu@458"));
	}  	
	 catch (ServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}
}

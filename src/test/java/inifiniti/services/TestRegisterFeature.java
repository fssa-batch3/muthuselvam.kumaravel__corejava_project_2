package inifiniti.services;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import inifiniti.App;
import inifiniti.model.User;
import inifiniti.services.exceptions.ServiceException;
public class TestRegisterFeature {
	@Test
	public  void testRegisterSuccess() {
		App app = new App();
		User user1 = new User("muthu123","sriyaasha@gmail.com","Muthu@456");
		UserService  UserService = new UserService();
		try {
			assertFalse(UserService.registerUser(user1));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	
	public void testInvalidPassword() {
		UserService userService = new UserService();
		User user = new User("muthu456","sriyaasha@gmail.com","Muthu458");
		
		
		try {
			
			assertFalse(userService.registerUser(user));
			
		} catch (ServiceException e) {
			e.getStackTrace();
			
		}
		
	}
	@Test
	
	
	public void testvalidPassword() {
		UserService userService = new UserService();
		User user = new User("muthu789","sriyaasha@gmail.com","Muthu@458");
		
		
		try {
			
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			System.out.println(e.getStackTrace());
			
		}
	}
	@Test
	public void testUserNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}





		
}




	
	


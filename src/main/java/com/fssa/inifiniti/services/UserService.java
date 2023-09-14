package com.fssa.inifiniti.services;


import java.util.List;

import com.fssa.inifiniti.dao.UserDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.UserValidator;
import com.fssa.inifiniti.validationexceptions.ValidationException;

public class UserService {
	
	/**
	 * Registers a new user in the system.
	 *
	 * @param user The User object containing user details to be registered.
	 * @return True if the user registration is successful, false otherwise.
	 * @throws ServiceException If an error occurs during the registration process or if user details are invalid.
	 */
	
public boolean registerUser(User user) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	
	try {  
		
		if(user == null) {
			throw new ValidationException("User cannot be null");
		}
		
	UserValidator.validateName(user.getUserName());
	UserValidator.validateEmail(user.getEmail());
	UserValidator.validatePassword(user.getPassword());
	return  userdao.emailAlreadyExists(user.getEmail()) &&
		    userdao.insertUser(user);
	
	}
	 catch (DaoException  | ValidationException e) {
		
		throw new ServiceException(e.getMessage());
	}
}

 
/**
 * Logs in a user with the provided email and password.
 *
 * @param email The email address of the user attempting to log in.
 * @param password The password associated with the user's account.
 * @return True if the login is successful; otherwise, an exception is thrown.
 * @throws ServiceException If an error occurs during the login process or if the email or password is invalid.
 */
public static boolean loginUser(String email, String password) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	
	try {
		
		if(email == null || email.trim().isEmpty()) {
			throw new ValidationException("Email cannot be null");
		}
		if(password == null || password.trim().isEmpty()) {
			throw new ValidationException("Password cannot be null");
		}
	UserValidator.validateEmail(email);
	UserValidator.validatePassword(password);
	 User  user = userdao.findUserByEmail(email);
	 if( email.equals(user.getEmail())){
		if(	password.equals(user.getPassword())) {
		 return true;
	 } else {
		 throw new DaoException("Invalid Password");
		 } 
	 } else {
		 throw new DaoException("Invalid Email");
	 }
	}
	 catch (DaoException | ValidationException e) {
		
		throw new ServiceException(e);
	}
}

/**
 * Retrieves the username associated with the provided email.
 *
 * @param email The email address for which to retrieve the associated username.
 * @return A User object containing the username if the email is registered; otherwise, an exception is thrown.
 * @throws ServiceException If an error occurs during the retrieval process or if the email is not registered.
 */

public  User findUserNameByEmail(String email) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	UserValidator validate =  new UserValidator();
	
	
	try {
		 validate.validateEmailId(email);
		return userdao.findUserNameByEmail(email);
		}
		 catch (DaoException  | ValidationException e) {
			
			throw new ServiceException(e);
		}
	
}

/**
 * Retrieves a list of all users in the system for administrative purposes.
 *
 * @return A list of User objects containing information about all registered users.
 * @throws ServiceException If an error occurs during the retrieval process.
 */

public  List<User> readUserByAdmin() throws ServiceException {
	UserDAO userDao =  new UserDAO();
	try {
		return userDao.viewAllUser();
	}
	 catch (DaoException  e) {
		throw new ServiceException(e);
	}
	
}



}  
package com.fssa.inifiniti.services;


import com.fssa.inifiniti.dao.UserDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.UserValidator;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class UserService {

public boolean registerUser(User user) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	
	try {
	if(UserValidator.validateUser(user)) {
	if(!userdao.emailAlreadyExists(user.getEmail())) {
		if( userdao.insertUser(user)){
			return true;
		} else {
			throw new ServiceException("registration not successful");
		}
	} else {
		throw new ServiceException("Email Already Exists");
	}
	}
	else {
		return false;
	}
	}
	 catch (DaoException | InvalidUserException e) {
		
		throw new ServiceException(e);
	}
}



public static boolean loginUser(String email, String password) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	
	try {
	UserValidator.ValidateLoginUser(email,password);
	 User  user = userdao.findUserByEmail(email);
		if(user.getEmail().equals(email) ){
			if(user.getPassword().equals(password)) {	
				userdao.setLoggedIn(email);
				return true;
			} else {
				throw new ServiceException("Invalid Password");
			}
			
		} else {
			throw new ServiceException("Login not successful");
		}
	}
	 catch (DaoException | InvalidUserException e) {
		
		throw new ServiceException(e);
	}
}}  
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
			return false;
		}
	} else {
		return false;
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
	UserValidator.validateLoginUser(email,password);
	 User  user = userdao.findUserByEmail(email);
		if(user.getEmail().equals(email) ){
			if(user.getPassword().equals(password)) {	
				userdao.setLoggedIn(email);
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	 catch (DaoException | InvalidUserException e) {
		
		throw new ServiceException(e);
	}
}

public  User findUserNameByEmail(String email) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	UserValidator validate =  new UserValidator();
	
	
	try {
		 validate.validateEmailId(email);
		 User  user = userdao.findUserNameByEmail(email);
			return user;
		}
		 catch (DaoException | InvalidUserException e) {
			
			throw new ServiceException(e);
		}
	
}}  
package com.fssa.inifiniti.services;


import java.util.List;

import com.fssa.inifiniti.dao.UserDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.UserValidator;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;
import com.fssa.inifiniti.validationexceptions.ValidationException;

public class UserService {

public boolean registerUser(User user) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	
	try {
		
	UserValidator.validateName(user.getUserName());
	UserValidator.validateEmail(user.getEmail());
	UserValidator.validatePassword(user.getPassword());
	return user != null && userdao.emailAlreadyExists(user.getEmail()) &&
		    userdao.insertUser(user);
	
	}
	 catch (DaoException  | ValidationException e) {
		
		throw new ServiceException(e.getMessage());
	}
}



public static boolean loginUser(String email, String password) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	
	try {
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

public  User findUserNameByEmail(String email) throws ServiceException {
	UserDAO userdao =  new UserDAO();
	UserValidator validate =  new UserValidator();
	
	
	try {
		 validate.validateEmailId(email);
		return userdao.findUserNameByEmail(email);
		}
		 catch (DaoException | InvalidUserException e) {
			
			throw new ServiceException(e);
		}
	
}


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
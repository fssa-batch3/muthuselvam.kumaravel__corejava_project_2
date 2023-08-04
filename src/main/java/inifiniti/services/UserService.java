package inifiniti.services;

import inifiniti.validation.UserValidator;
import inifiniti.validationexceptions.InvalidUserException;

import java.sql.SQLException;

import inifiniti.dao.*;
import inifiniti.dao.exceptions.DaoException;
import inifiniti.model.*;
import inifiniti.services.exceptions.ServiceException;

public class UserService {

public boolean registerUser(User user) throws ServiceException {
	UserDao userdao =  new UserDao();
	
	try {
	UserValidator.ValidateUser(user);	
	if(userdao.emailAlreadyExists(user.getEmail())==false) {
		if( userdao.insertUser(user)){
			System.out.println(user.getUserName() + " successful");
			return true;
		} else {
			System.out.println("registration not successful");
			return false;
		}
	} else {
		System.out.println("Email Already Exists");
		return false;
	}
	}
	 catch (SQLException | InvalidUserException e) {
		
		throw new ServiceException(e);
	}
}



public static boolean LoginUser(String email, String password) throws ServiceException {
	UserDao userdao =  new UserDao();
	
	try {
	UserValidator.ValidateLoginUser(email,password);
	 User  user = userdao.findUserByEmail(email);
		if(user.getEmail().equals(email) ){
			if(user.getPassword().equals(password)) {	
				System.out.println("Login successful");
				return true;
			} else {
				System.out.println("Invalid Password");
				return false;
			}
			
		} else {
			System.out.println("Login not successful");
			return false;
		}
	}
	 catch (DaoException | InvalidUserException e) {
		
		throw new ServiceException(e);
	}
}
}     

package com.fssa.inifiniti.services;


import com.fssa.inifiniti.dao.UserDao;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.UserValidator;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

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
	 catch (DaoException | InvalidUserException e) {
		
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

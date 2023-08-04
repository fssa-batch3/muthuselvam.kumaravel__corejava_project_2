package inifiniti.services;

import java.sql.SQLException;

import inifiniti.dao.UserDao;
import inifiniti.dao.*;
import inifiniti.model.Booking;
import inifiniti.model.User;
import inifiniti.services.exceptions.ServiceException;
import inifiniti.validation.BookingValidator;
import inifiniti.validation.UserValidator;
import inifiniti.validationexceptions.InvalidUserException;

public class BookingService {

	public static boolean registerBooking(Booking booking) throws ServiceException {
		BookingDao bookingdao =  new BookingDao();
		
		try {
		BookingValidator.ValidateBooking(booking);	
			if( bookingdao.insertBooking(booking)){
				System.out.println(booking.getUserName() +" and seat num: "+ booking.getSeatNum() + " successful");
				return true;
			} else {
				System.out.println("booking not successful");
				return false;
			}
		
		}
		 catch (SQLException | InvalidUserException e) {
			
			throw new ServiceException(e);
		}
	}

}

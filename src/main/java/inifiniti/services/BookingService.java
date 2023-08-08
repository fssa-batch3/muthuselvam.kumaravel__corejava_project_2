package inifiniti.services;

import java.sql.SQLException;

import inifiniti.dao.BookingDao;
import inifiniti.dao.UserDao;
import inifiniti.model.Booking;
import inifiniti.services.exceptions.ServiceException;
import inifiniti.validation.BookingValidator;
import inifiniti.validation.UserValidator;
import inifiniti.validationexceptions.InvalidBookingException;

public class BookingService {

	public static boolean registerBooking(Booking booking) throws ServiceException {
		BookingDao bookingdao =  new BookingDao();
		try {
		BookingValidator.ValidateBooking(booking);	
		if(bookingdao.seatNumAlreadyExists(booking.getShuttle_id(), booking.getSeatNum())== true) {
			System.out.println("Seat num already exists");
			return false;
		} else {
			if( bookingdao.insertBooking(booking)){
				System.out.println(booking.getUserName() +" and seat num: "+ booking.getSeatNum() + " successful");
				return true;
			} else {
				System.out.println("booking not successful");
				return false;
			}
		}
		
		}
		 catch (SQLException | InvalidBookingException e) {
			
			throw new ServiceException(e);
		}
	}
	
	public static boolean editBooking(int shuttle_id , String email , int seatNum , int changeSeatNum) throws ServiceException {
		BookingDao bookingdao =  new BookingDao();
		UserDao user = new UserDao();
		try {
		BookingValidator.validateSeatNum(seatNum);	
		BookingValidator.validateSeatNum(changeSeatNum);
		if(UserValidator.validateEmail(email)) {
			Booking booking = bookingdao.findUserForEditSeatNum(shuttle_id, email, seatNum);
			booking.setSeatNum(changeSeatNum);
			bookingdao.inserteditBooking(booking);
			System.out.println("Edit Seat Num : Successful");
			return true;
		} else {
				System.out.println("Edit Seat Num : Not Successful");
				return false;
		}
		}
		 catch (InvalidBookingException e) {
			throw new ServiceException(e);
		}
	}

	
	
	public static boolean deleteBooking(Booking booking) throws ServiceException {
		BookingDao bookingdao =  new BookingDao();
		UserDao user = new UserDao();
		try {
		if(UserValidator.validateEmail(booking.getEmail())) {
			BookingDao.deleteBooking(booking.getShuttle_id(),booking.getEmail());
			System.out.println("Delete Booking : Successful");
			return true;
		} else {
				System.out.println("Delete Booking : Not Successful");
				return false;
		}
		}
		 catch (InvalidBookingException e) {
			throw new ServiceException(e);
		}
	}

	
	public static boolean readBookingByUser(Booking booking) throws ServiceException {
		BookingDao bookingdao =  new BookingDao();
		UserDao user = new UserDao();
		try {
		if(UserValidator.validateEmail(booking.getEmail())) {
			BookingDao.viewBookingsByUser(booking);
			System.out.println("Booking History - User: Successful");
			return true;
		} else {
				System.out.println("Booking History - User: Not Successful");
				return false;
		}
		}
		 catch (InvalidBookingException e) {
			throw new ServiceException(e);
		}
	}

}

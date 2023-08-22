package com.fssa.inifiniti.services;

import com.fssa.inifiniti.dao.BookingDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.BookingValidator;
import com.fssa.inifiniti.validationexceptions.InvalidBookingException;

public class BookingService {
	
	 public static final BookingDAO bookingDao = new BookingDAO();

	public static boolean registerBooking(Booking booking) throws ServiceException {

		try {
		BookingValidator.validateBooking(booking);	
		if(bookingDao.seatNumAlreadyExists(booking.getShuttleId(), booking.getSeatNum())) {
			System.out.println("Seat num already exists");
			return false;
		} else {
			if( bookingDao.createBooking(booking)){
				System.out.println(booking.getUserName() +" and seat num: "+ booking.getSeatNum() + " successful");
				return true;
			} else {
				System.out.println("booking not successful");
				return false;
			}
		} 
		
		}
		 catch (DaoException  | InvalidBookingException e) {
			
			throw new ServiceException(e);
		}
	}
	
	public static boolean updateBooking(int shuttleId , String email , int seatNum , int changeSeatNum) throws ServiceException {
		try {
		BookingValidator.validateSeatNum(seatNum);	
		BookingValidator.validateSeatNum(changeSeatNum);
		if(BookingValidator.validateEmail(email)) {
			Booking booking = bookingDao.findUserForEditSeatNum(shuttleId, email, seatNum);
			booking.setSeatNum(changeSeatNum);
			bookingDao.editBooking(booking);
			System.out.println("Edit Seat Num : Successful");
			return true;
		} else {
				System.out.println("Edit Seat Num : Not Successful");
				return false;
		}
		}
		 catch (DaoException  | InvalidBookingException  e) {
			throw new ServiceException(e);
		}
	}

	
	
	public static boolean deleteBooking(Booking booking) throws ServiceException {
		try {
		if(BookingValidator.validateEmail(booking.getEmail())) {
			bookingDao.deleteBooking(booking.getShuttleId(),booking.getEmail());
			System.out.println("Delete Booking : Successful");
			return true;
		} else {
				System.out.println("Delete Booking : Not Successful");
				return false;
		}
		}
		 catch (DaoException  | InvalidBookingException  e) {
			throw new ServiceException(e);
		}
	}

	
	public static boolean readBookingByUser(Booking booking) throws ServiceException {
		try {
		if(BookingValidator.validateEmail(booking.getEmail())) {
			bookingDao.viewBookingsByUser(booking);
			System.out.println("Booking History - User: Successful");
			return true;
		} else {
				System.out.println("Booking History - User: Not Successful");
				return false;
		}
		}
		 catch (DaoException  | InvalidBookingException  e) {
			throw new ServiceException(e);
		}
	}
	
	public static boolean readBookingByAdmin() throws ServiceException {
		try {
			bookingDao.viewBookingsByAdmin();
			System.out.println("Booking History - Admin: Successful");
			return true;
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}

}

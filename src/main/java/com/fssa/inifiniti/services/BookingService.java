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
			throw new  ServiceException("Seat num already exists");
		} else {
			if( bookingDao.createBooking(booking)){
				return true;
			} else {
				throw new ServiceException("Invalid in Booking Credentials");
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
			return true;
		} else {
			throw new ServiceException("Edit Seat Num : Not Successful");
		}
		}
		 catch (DaoException   e) {
			throw new ServiceException(e);
		}
	}

	
	
	public static boolean deleteBooking(Booking booking) throws ServiceException {
		try {
		if(BookingValidator.validateEmail(booking.getEmail())) {
			bookingDao.deleteBooking(booking.getShuttleId(),booking.getEmail());
			return true;
		} else {
			throw new ServiceException("Delete Booking : Not Successful");
		}
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}

	
	public static boolean readBookingByUser(Booking booking) throws ServiceException {
		try {
		if(BookingValidator.validateEmail(booking.getEmail())) {
			bookingDao.viewBookingsByUser(booking);
			return true;
		} else {
			throw new ServiceException("Booking History - User: Not Successful");
		}
		}
		 catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	public static boolean readBookingByAdmin() throws ServiceException {
		try {
			bookingDao.viewBookingsByAdmin();
			return true;
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}

}

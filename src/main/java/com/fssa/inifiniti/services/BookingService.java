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
		BookingValidator.validateShuttleId(booking.getShuttleId());
		if(bookingDao.seatNumAlreadyExists(booking.getShuttleId(), booking.getSeatNum())) {
			return false;
		} else {
			if(bookingDao.shuttleIdAlreadyExists(booking.getShuttleId()) && bookingDao.createBooking(booking)){
				return true;
			} else { 
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
		BookingValidator.validateShuttleId(shuttleId);
		if(bookingDao.shuttleIdAlreadyExists(shuttleId) && BookingValidator.validateEmail(email)) {
			Booking booking = bookingDao.findUserForEditSeatNum(shuttleId, email, seatNum);
			booking.setSeatNum(changeSeatNum);
			bookingDao.editBooking(booking);
			return true;
		} 
		return false;
		}
		 catch (DaoException   e) {
			throw new ServiceException(e);
		}
	}

	
	
	public static boolean deleteBooking(Booking booking) throws ServiceException {
		try {
		if(BookingValidator.validateEmail(booking.getEmail()) && BookingValidator.validateShuttleId(booking.getShuttleId())) {
			bookingDao.shuttleIdAlreadyExists(booking.getShuttleId());
			bookingDao.deleteBooking(booking.getShuttleId(),booking.getEmail());
			return true;
		}
		return false;
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
		} 
		return false;
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

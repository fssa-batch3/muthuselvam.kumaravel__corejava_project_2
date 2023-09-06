package com.fssa.inifiniti.services;

import java.util.ArrayList;
import java.util.List;

import com.fssa.inifiniti.dao.BookingDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.BookingValidator;
import com.fssa.inifiniti.validationexceptions.ValidationException;

public class BookingService {
	
	 public static final BookingDAO bookingDao = new BookingDAO();

	public static boolean registerBooking(Booking booking) throws ServiceException {

		try {
		BookingValidator.validateBooking(booking);	
		BookingValidator.validateShuttleId(booking.getShuttleId());
		return 	bookingDao.shuttleIdAlreadyExists(booking.getShuttleId()) &&
			    bookingDao.seatNumAlreadyExistsInSameShuttle(booking.getShuttleId(), booking.getSeatNum()) && 
				bookingDao.createBooking(booking);
		
		} 
		 catch (DaoException  | ValidationException e) {
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
		 catch (DaoException | ValidationException  e) {
			throw new ServiceException(e);
		}
	}
	
	public boolean updateBookingByBookingId(int bookingId , String destination , int seatNum , int shuttleId) throws ServiceException {
		try {
		BookingValidator.validateSeatNum(seatNum);	
		BookingValidator.validateDestination(destination);	
		BookingValidator.validateShuttleId(shuttleId);
			BookingDAO bookingDao = new BookingDAO();
			return bookingDao.editBookingByBookingId(seatNum, destination, bookingId);
		}
		 catch (DaoException | ValidationException  e) {
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
		 catch (DaoException | ValidationException e) {
			throw new ServiceException(e);
		}
	}
	
	public static boolean deleteBookingByBookingId(int bookingId) throws ServiceException {
		try {
			return bookingDao.deleteBookingByBookingId(bookingId);
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}

	
	public List<Booking> readBookingByUser(Booking booking) throws ServiceException {
		try {
			if( BookingValidator.validateEmail(booking.getEmail())) {
			return  bookingDao.viewBookingsByUser(booking);
			} else {
				throw new DaoException("Invalid Email");
			}
			
		} 
		
		 catch (DaoException | ValidationException e) {
			throw new ServiceException(e);
		}
		
	}
	
	public  List<Booking> readBookingByAdmin() throws ServiceException {
		List<Booking> bookings = new ArrayList<>();
		try {
		return bookings = bookingDao.viewBookingsByAdmin();
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}

}
